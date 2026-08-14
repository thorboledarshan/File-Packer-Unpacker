\# Java File Packer-Unpacker



A Java-based File Packer-Unpacker application that combines multiple supported files into a single pack file and later extracts them back to their original form.



The project uses Java File I/O, fixed-size metadata headers, buffer-based processing, XOR-based encryption/decryption, and a Swing-based graphical user interface.



\---



\## Project Overview



The application provides two main operations:



\- \*\*PACK\*\* — Collects supported files from a selected folder and stores them in a single pack file.

\- \*\*UNPACK\*\* — Reads the pack file and recreates the original files.



The application also provides a graphical interface using Java Swing.



\---



\## Features



\- Pack multiple files into a single pack file

\- Unpack files from the generated pack file

\- Support for:

&#x20; - `.txt`

&#x20; - `.c`

&#x20; - `.cpp`

&#x20; - `.java`

\- Handles filenames containing spaces

\- Fixed 100-byte metadata header

\- Stores filename and file size in the header

\- XOR-based encryption during packing

\- XOR-based decryption during unpacking

\- 1024-byte buffer-based file processing

\- Swing GUI

\- Folder and file browsing using `JFileChooser`

\- Input validation

\- Status messages and error handling

\- `try-with-resources` for stream management



\---



\## Technologies Used



| Technology | Purpose |

|---|---|

| Java | Core programming language |

| Java I/O | File and stream handling |

| Java Swing | Graphical User Interface |

| `FileInputStream` | Reading files |

| `FileOutputStream` | Writing files |

| `JFileChooser` | File/folder selection |

| XOR | Basic data encryption/decryption |

| Git/GitHub | Version control |



\---



\## Project Structure



```text

File-Packer-Unpacker/

│

├── src/

│   ├── FilePacker.java

│   ├── FileUnpacker.java

│   └── FilePackerUnpackerGUIX.java

│

├── screenshots/

│   └── GUI screenshots

│

├── .gitignore

└── README.md

