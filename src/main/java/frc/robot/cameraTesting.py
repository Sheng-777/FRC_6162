import cv2
import imutils
import numpy as np
from imutils import paths

KNOWN_RADIUS = 12.3
KNOWN_DISTANCE = 30
def find_marker(image):
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    gray = cv2.GaussianBlur(gray, (5, 5), 0)
    edged = cv2.Canny(gray, 35, 125)
    # find the contours in the edged image and keep the largest one;
    # we'll assume that this is our piece of paper in the image
    cnts = cv2.findContours(edged.copy(), cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)
    cnts = imutils.grab_contours(cnts)
    c = max(cnts, key = cv2.contourArea)
    # compute the bounding box of the of the paper region and return it
    return cv2.minAreaRect(c)

def distance_to_camera(knownWidth, focalLength, perWidth):
	# compute and return the distance from the maker to the camera
	return (knownWidth * focalLength) / perWidth

image = cv2.imread("target.jpg")
marker = find_marker(image)
focalLength = (marker[1][0] * KNOWN_DISTANCE) / KNOWN_RADIUS
fonts = cv2.FONT_HERSHEY_COMPLEX

cap = cv2.VideoCapture(1)
while cap.isOpened:
    ret, frame = cap.read()
    marker = find_marker(image)
    distance = distance_to_camera(KNOWN_RADIUS, focalLength, marker[1][0])
    cv2.line(frame, (30, 30), (230, 30), (0,0,255), 32) 
    cv2.line(frame, (30, 30), (230, 30), (0,0,0), 28) 
    
    cv2.putText( 
            frame, f"Distance: {round(distance,2)} CM", (30, 35),  
          fonts, 0.6, (0,255,0), 2) 
     
    cv2.imshow("frame", frame)

    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
    
cap.release()

cv2.destroyAllWindows()