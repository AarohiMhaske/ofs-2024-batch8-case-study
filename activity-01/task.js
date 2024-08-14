import fs from 'fs';
import readline from 'readline-sync';

// Define the file path for employee data
const filePath = 'employees.json';

// Function to read existing employee data from a JSON file
function readEmployees() {
  try {
    if (fs.existsSync(filePath)) {
      const data = fs.readFileSync(filePath, 'utf8');
      return JSON.parse(data);
    } else {
      return [];
    }
  } catch (error) {
    console.error('Error reading file:', error);
    return [];
  }
}

// Function to write employee data to a JSON file
function writeEmployees(employees) {
  try {
    fs.writeFileSync(filePath, JSON.stringify(employees, null, 2), 'utf8');
  } catch (error) {
    console.error('Error writing file:', error);
  }
}

// Function to get employee details from user input
function getEmployeeDetails() {
  const id = readline.question('Enter employee ID: ');
  const name = readline.question('Enter employee name: ');
  let salary = parseFloat(readline.question('Enter employee salary: '));
  
  // Validate salary
  while (isNaN(salary) || salary <= 0) {
    console.log('Invalid salary. Please enter a positive number.');
    salary = parseFloat(readline.question('Enter employee salary: '));
  }

  return { id, name, salary };
}

// Main function to handle adding employee data and printing all employees
function main() {
  // Read existing employee data
  let employees = readEmployees();

  // Get new employee details from user
  const newEmployee = getEmployeeDetails();

  // Add the new employee to the list
  employees.push(newEmployee);

  // Write the updated employee data to the JSON file
  writeEmployees(employees);

  // Read and print all employee details
  console.log('....All employee details....');
  employees.forEach(employee => {
    console.log(`ID: ${employee.id}, Name: ${employee.name}, Salary: ${employee.salary}`);
  });
}

// Run the main function
main();
