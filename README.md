# Contact Manager

A simple Java project that implements a Contact Manager using a text document as the database. The project performs CRUD (Create, Read, Update, Delete) operations on the text document to manage contacts effectively.

---

## Features

- **Create Contact**: Add new contacts to the database.
- **Read Contact**: Search for specific contacts.
- **Update Contact**: Edit the details of an existing contact.
- **Delete Contact**: Remove a contact from the database.

---

## Prerequisites

- **Java**: Ensure you have JDK 8 or higher installed.
- **IDE**: Any Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans) or a text editor.

---

## How It Works

1. The contact database is stored in a plain text file (`data.txt`).
2. Each line in the text file represents a contact, formatted as:
   ```
   Name,Phone,Email
   ```
3. The application reads the file, parses the data, and allows CRUD operations to be performed.

---

## Project Structure

```
ContactManager
├── src
│   ├── Main.java
│   ├── Contact.java
│   ├── ContactManager.java
├── data.txt
└── README.md
```

- **Main.java**: Contains the main method and handles the user interface.
- **Contact.java**: Represents the Contact model with attributes such as name, phone, and email.
- **ContactManager.java**: Contains the logic for CRUD operations on the text file.
- **data.txt**: The text file database for storing contact information.

---

## Installation

1. Clone this repository:
   ```
   git clone https://github.com/aniruddha81/Contact-Manager_-text-based-.git
   ```

2. Open the project in your preferred IDE.
3. Ensure the `data.txt` file exists in the project root directory.
4. Run the `Main.java` file.

---

## Usage

- Launch the application.
- Select one of the following options:
  - Add a new contact
  - Search for a contact
  - Update an existing contact
  - Delete a contact
- Follow the prompts to complete your operation.

---

## Sample Contact File

```
John Doe,1234567890,john.doe@example.com
Jane Smith,0987654321,jane.smith@example.com
```

---

## Contributing

1. Fork the repository.
2. Create a new branch for your feature/bug fix:
   ```
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```
   git commit -m "Description of changes"
   ```
4. Push to your branch:
   ```
   git push origin feature-name
   ```
5. Open a pull request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For any queries or suggestions, feel free to reach out:

- **Email**: ar.roy564@gmail.com
- **GitHub**: [aniruddha81](https://github.com/aniruddha81)

