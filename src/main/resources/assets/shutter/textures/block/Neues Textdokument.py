import os

files = os.listdir()
for i in files:
    if i.endswith(".png"):
        os.rename(i, i.replace("top", "upper").replace("bottom", "lower"))
