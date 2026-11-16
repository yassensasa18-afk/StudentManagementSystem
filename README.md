# Student Management System
Java console application for BIT1123 Assignment 2, City University Malaysia.

## Run on Windows
Install JDK 17 or later. Extract the ZIP and double-click `run.bat`.
Alternatively open CMD in this folder:
```
javac -d out src/*.java
java -cp out Main
```
## Features
Add students, lecturers and courses; display people and courses; register students; view registrations; reject duplicate IDs, course codes and enrolments.
Data is held in memory and cleared when the program exits.
## OOP
- Person: abstract superclass with private ID and name and validated setters.
- Student and Lecturer extend Person and override getDetails().
- Main displays a List<Person> to demonstrate runtime polymorphism.
- Student associates with many courses; each course optionally associates with one lecturer.

## Upload yourself to GitHub
1. Create a new repository named StudentManagementSystem.
2. Click Add file > Upload files.
3. Upload the extracted project contents (not only the ZIP). Keep the src folder.
4. Click Commit changes.
5. Copy the repository URL into the report and export the updated report as PDF.

## Before submission
Complete both students' names, IDs, class code, programme and GitHub URL on the report cover.
Read and evaluate the code and report, then complete the AI declaration and signatures.
AI assistance: ChatGPT generated code, documentation, report and UML; automated verification is described in Verification.txt.
