import random

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


def writing_text(image, text, x, y):
    font = cv2.FONT_ITALIC
    cv2.putText(image, text, (x, y), font, 3, (255, 255, 255), 2, cv2.LINE_AA)
    return image

x, y = 30, 100

file = f.readline(open("parameters/backgroung.txt", "r"))
col = file[0]
path = 'background/' + col + '.png'
print(path)
background = cv2.imread(path)
background = resize(background, WIDTH, HEIGHT)

file = open("parameters/other_pictures", "r")
print(file)
for i in range(len(file)):
    num = random.randint(1, 20)
    path = 'other_pictures/' + num + '.png'
    picture = cv2.imread(path, cv2.IMREAD_UNCHANGED)
    picture = resize(picture, 150, 100)
    final_image = overlay(background, picture, x, y)
    cv2.imwrite("final_image/merged_transparent.png", final_image)

picture = cv2.imread('central_picture/dog.png', cv2.IMREAD_UNCHANGED)
picture = resize(picture, 250, 200)

final_image = overlay(background, picture, 30, 100)
cv2.imwrite("final_image/merged_transparent.png", final_image)

font = cv2.FONT_HERSHEY_SIMPLEX
final_image = writing_text(final_image, 'DAposter', 10, 100)
cv2.imwrite("final_image/merged_transparent.png", final_image)
cv2.imshow("Image", final_image)
cv2.waitKey(0)
#plt.imshow(final_image)
#plt.show()


