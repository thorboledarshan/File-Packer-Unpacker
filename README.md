# Java File Packer-Unpacker

A Java-based desktop application that combines multiple files into a single **pack file** and later **extracts** them back to their original form — complete with XOR-based encryption/decryption and a Swing GUI.

![Java](https://img.shields.io/badge/Java-8%2B-orange?logo=openjdk)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![License](https://img.shields.io/badge/license-MIT-green)

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [How It Works](#how-it-works)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Compilation](#compilation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [Supported File Types](#supported-file-types)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

**File Packer-Unpacker** provides two core operations:

| Operation  | Description |
|------------|-------------|
| **PACK**   | Scans a selected folder for supported files and combines them into a single pack file, encrypting their contents along the way. |
| **UNPACK** | Reads a pack file, decrypts its contents, and reconstructs the original files exactly as they were. |

The application is built entirely on core Java — file I/O, buffered stream processing, and a fixed-size metadata header scheme — with a Swing GUI as the front end.

---

## Features

- 📦 Pack multiple files into a single archive file
- 📂 Unpack files back to their original form
- 🔐 XOR-based encryption during packing and decryption during unpacking
- 🗂️ Fixed 100-byte metadata header storing filename and file size
- 🧵 1024-byte buffer-based file processing for efficient I/O
- 🖱️ Swing-based graphical user interface
- 📁 Folder and file browsing via `JFileChooser`
- ✅ Input validation, status messages, and error handling
- 🔒 Safe stream management using `try-with-resources`
- 📝 Handles filenames containing spaces

---

## How It Works

1. **Packing**
   - The user selects a source folder via the GUI.
   - The app scans the folder for supported file types.
   - For each file, a 100-byte metadata header (filename + file size) is written to the pack file, followed by the file's contents.
   - Each byte of file data is XOR-encrypted before being written, using a 1024-byte buffer.

2. **Unpacking**
   - The user selects an existing pack file.
   - The app reads each 100-byte header to determine the original filename and size.
   - The corresponding bytes are read, XOR-decrypted, and written out to reconstruct the original file.

---

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core programming language |
| Java I/O (`FileInputStream`, `FileOutputStream`) | Reading and writing files/streams |
| Java Swing | Graphical User Interface |
| `JFileChooser` | File and folder selection dialogs |
| XOR Cipher | Lightweight data encryption/decryption |
| Git/GitHub | Version control |

---

## Project Structure

```
File-Packer-Unpacker/
│
├── src/
│   ├── FilePacker.java                 # Handles packing logic
│   ├── FileUnpacker.java               # Handles unpacking logic
│   └── FilePackerUnpackerGUIX.java     # Swing GUI entry point
│
├── screenshots/
│   └── GUI screenshots
│
├── .gitignore
└── README.md
```

---

## Getting Started

### Prerequisites

- [Java Development Kit (JDK) 8+](https://www.oracle.com/java/technologies/downloads/) installed
- A terminal / command prompt, or an IDE such as IntelliJ IDEA, Eclipse, or VS Code

### Compilation

Clone the repository and compile the source files:

```bash
git clone https://github.com/thorboledarshan/File-Packer-Unpacker.git
cd File-Packer-Unpacker/src
javac *.java
```

### Running the Application

Launch the GUI:

```bash
java FilePackerUnpackerGUIX
```

---

## Usage

1. Launch the application — the Swing GUI window will open.
2. **To pack files:**
   - Select **Pack**.
   - Browse and select the source folder containing the files you want to pack.
   - Choose a destination and name for the output pack file.
   - Click **Pack** to generate the encrypted pack file.
3. **To unpack files:**
   - Select **Unpack**.
   - Browse and select the pack file you want to extract.
   - Choose a destination folder.
   - Click **Unpack** to decrypt and restore the original files.
4. Status messages in the GUI will confirm success or report any errors encountered.

---

## Screenshots

Screenshots of the GUI are available in the [`screenshots/`](./screenshots) directory.

---

## Supported File Types

- `.txt`
- `.c`
- `.cpp`
- `.java`

> Support for additional file types can be added by extending the file filter logic in `FilePacker.java`.

---

## Roadmap

- [ ] Support for additional file types
- [ ] Stronger encryption (e.g., AES) as an alternative to XOR
- [ ] Progress bar for large pack/unpack operations
- [ ] Drag-and-drop support in the GUI
- [ ] Command-line interface (CLI) mode

---

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m "Add your feature"`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

Please open an issue first to discuss significant changes.

---

## License

This project is licensed under the [MIT License](LICENSE) — feel free to use, modify, and distribute it.

---

## Author

**Darshan Thorbole**
[GitHub](https://github.com/thorboledarshan) · [Repository](https://github.com/thorboledarshan/File-Packer-Unpacker)