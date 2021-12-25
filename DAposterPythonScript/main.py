import cv2
import numpy as np
import matplotlib.pyplot as plt

WIDTH, HEIGHT = 500, 400


def resize(image, width, height):
    new_size = [width, height]
    resized = cv2.resize(image, new_size, interpolation=cv2.INTER_AREA)
    return resized


def overlay(background, img, x, y):
    b = np.copy(background)
    place = b[y: y + img.shape[0], x: x + img.shape[1]]
    a = img[..., 3:].repeat(3, axis=2).astype('uint16')
    place[..., :3] = (place[..., :3].astype('uint16') * (255 - a) // 255) + img[..., :3].astype('uint16') * a // 255
    return b


background = cv2.imread('background/fon.png')
background = resize(background, WIDTH, HEIGHT)
plt.imshow(background)
plt.show()

picture = cv2.imread('central_picture/dog.png', cv2.IMREAD_UNCHANGED)
picture = resize(picture, 250, 200)
plt.imshow(picture)
plt.show()

final_image = overlay(background, picture, 50, 50)
cv2.imwrite("final_image/merged_transparent.png", final_image)
plt.imshow(final_image)
plt.show()
font = cv2.FONT_HERSHEY_SIMPLEX
cv2.putText(final_image, 'DAposter', (10, 100), font, 3, (255, 255, 255), 2, cv2.LINE_AA)
cv2.imwrite("final_image/merged_transparent.png", final_image)
plt.imshow(final_image)
plt.show()

