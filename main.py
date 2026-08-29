from PIL import Image
import os
import re
from collections import defaultdict

BLOCKS_DIR = "block"        # folder with your 8 tiles per set
OUT_DIR = "."                # where to write the final sheet(s)

# Expected 8 variants and their position on a 3×3 grid (tile size 32×32).
# This layout mirrors the provided “Unbenannt.png” (bottom-right stays empty).
SUFFIXES = [
    "lower",
    "middle",
    "upper",
    "normal",
    
    "lower_big",
    "middle_big",
    "upper_big",
    "normal_big",
]

LAYOUT = {
    "upper":      (0, 0),
    "middle":     (1, 0),
    "lower":      (2, 0),
    "normal":     (0, 1),
    
    "normal_big": (2, 1),
    "middle_big": (0, 2),
    "upper_big":  (1, 2),
    "lower_big":  (2, 2),
}

TILE = 32
SHEET_W = TILE * 3
SHEET_H = TILE * 3

def find_groups(blocks_dir: str):
    """Group files by common prefix, keyed by the 8 expected suffixes."""
    groups = defaultdict(dict)
    for fn in os.listdir(blocks_dir):
        if not fn.lower().endswith(".png"):
            continue
        name = os.path.splitext(fn)[0]
        m = re.match(r"(.+?)_(upper|upper_big|normal|normal_big|middle|middle_big|lower|lower_big)$", name)
        if not m:
            continue
        prefix, suffix = m.groups()
        groups[prefix][suffix] = os.path.join(blocks_dir, fn)
    return groups

def build_sheet(prefix: str, files: dict, out_dir: str):
    sheet = Image.new("RGBA", (SHEET_W, SHEET_H), (0, 0, 0, 0))
    for suffix in SUFFIXES:
        img = Image.open(files[suffix]).convert("RGBA")
        if img.size != (TILE, TILE):
            img = img.resize((TILE, TILE))
        x, y = LAYOUT[suffix]
        sheet.paste(img, (x * TILE, y * TILE), img)
    out_path = os.path.join(out_dir, f"{prefix}.png")
    sheet.save(out_path)
    return out_path

def main():
    groups = find_groups(BLOCKS_DIR)
    made = []
    for prefix, files in groups.items():
        if all(s in files for s in SUFFIXES):
            made.append(build_sheet(prefix, files, OUT_DIR))
    if not made:
        print("No complete 8-tile sets found.")
    else:
        print("Wrote:\n" + "\n".join(made))

if __name__ == "__main__":
    main()
