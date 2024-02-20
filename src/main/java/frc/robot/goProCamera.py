import cv2
from goprocam import GoProCamera, constants
from goprohero import GoProHero
from time import time
import socket

gpCam = GoProCamera.GoPro()
sock = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
t = time()
gpCam.livestream("start")

gpCam.video_settings(res="720p", fps="30")
gpCam.gpControlSet(constants.Stream.WINDOW_SIZE, constants.Stream.WindowSize.R720)
cap = cv2.VideoCapture("udp://10.5.5.9:8554",cv2.CAP_FFMPEG)

while True:
    nmat, frame = cap.read()
    cv2.imshow("Go Pro OpenCV", frame)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
    if time() - t >= 2.5:
        sock.sendto("_GPHD_:0:0:2:0.000000\n".encode(), ("10.5.5.9",8554))

cap.release()
cv2.destroyAllWindows()