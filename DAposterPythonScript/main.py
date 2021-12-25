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


x = [50, 400, 50, 400]
y = [50, 50, 350, 350]

with open('parameters/backgroung.txt') as file:
    col = file.readlines()
    path = 'background/' + col[0] + '.png'
    print(path)
    background = cv2.imread(path)
    background = resize(background, WIDTH, HEIGHT)
    file.close()

with open("parameters/other_pictures.txt") as file:
    list_other_pictures = file.readlines()
    str1 = " ".join(list_other_pictures)
    str1 = str1.split()
    j = 0
    for i in str1:
        num = random.randint(1, 20)
        num = str(num)
        path = 'other_pictures/' + i + num + '.png'
        print(path)
        picture = cv2.imread(path, cv2.IMREAD_UNCHANGED)
        picture = resize(picture, 50, 100)
        final_image = overlay(background, picture, x[j], y[j])
        cv2.imwrite("final_image/merged_transparent.png", final_image)
        j += 1
    file.close()

num = random.randint(1, 12)
num = str(num)
path = 'central_pictures/Mario (' + num + ').png'
print(path)
picture = cv2.imread(path, cv2.IMREAD_UNCHANGED)
picture = resize(picture, 250, 200)


final_image = overlay(final_image, picture, 200, 150)
cv2.imwrite("final_image/merged_transparent.png", final_image)

font = cv2.FONT_HERSHEY_SIMPLEX
final_image = writing_text(final_image, 'DAposter', 10, 100)
cv2.imwrite("final_image/merged_transparent.png", final_image)
cv2.imshow("Image", final_image)
cv2.waitKey(0)