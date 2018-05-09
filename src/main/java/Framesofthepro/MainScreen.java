package Framesofthepro;

import domain.*;
import java.util.Scanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;

public class MainScreen {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField Username1;
	private JTextField Name1;
	private JTextField City1;
	private JTextField HouseNum1;
	private JTextField Age1;
	private JTextField StreetName1;
	private JTextField Name3;
	private JTextField Salary3;
	private JTextField StreetName3;
	private JTextField Age3;
	private JTextField City3;
	private JTextField HouseNum3;
	private JTextField Name2;
	private JTextField Grade;
	private JTextField StreetName2;
	private JTextField Age2;
	private JTextField City2;
	private JTextField HouseNum2;

	private static ArrayList<Administrator> arrayadmins = new ArrayList<Administrator>();
	private static ArrayList<Employee> arrayemployees = new ArrayList<Employee>();
	private static ArrayList<Student> arraystudents = new ArrayList<Student>();
	private JPasswordField Password1;
	private static ObjectMapper om = new ObjectMapper();

	/**
	 * Launch the application.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		File FileAdmin = new File("Admins.txt");
		File FileStudent = new File("Students.txt");
		File FileEmployee = new File("Employees.txt");

		// Read the files -- I know it can be one interface method but this is easier :P
		if (FileAdmin.exists()) {
			if (new Scanner(FileAdmin).hasNextLine()) {
				try {
					arrayadmins = om.readValue(new Scanner(FileAdmin).nextLine(),
							new TypeReference<ArrayList<Administrator>>() {
							});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (FileStudent.exists()) {
			if (new Scanner(FileStudent).hasNextLine()) {
				try {
					arraystudents = om.readValue(new Scanner(FileStudent).nextLine(),
							new TypeReference<ArrayList<Student>>() {
							});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (FileEmployee.exists()) {
			if (new Scanner(FileEmployee).hasNextLine()) {
				try {
					arrayemployees = om.readValue(new Scanner(FileEmployee).nextLine(),
							new TypeReference<ArrayList<Employee>>() {
							});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tabbedPane.setBounds(0, 0, 808, 521);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Administrator", null, panel, null);
		panel.setLayout(null);

		JLabel lblStreetNameA = new JLabel("Street name");
		lblStreetNameA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreetNameA.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameA.setBounds(205, 95, 96, 29);
		panel.add(lblStreetNameA);

		JLabel lblHouseNumberA = new JLabel("House number");
		lblHouseNumberA.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHouseNumberA.setBounds(193, 131, 96, 29);
		panel.add(lblHouseNumberA);

		JLabel lblCityA = new JLabel("City");
		lblCityA.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityA.setBounds(403, 95, 96, 29);
		panel.add(lblCityA);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(-7, 65, 116, 47);
		panel.add(lblUsername);

		JLabel Passwordlbl = new JLabel("Password");
		Passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Passwordlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Passwordlbl.setBounds(-7, 210, 116, 38);
		panel.add(Passwordlbl);

		JLabel lblNameA = new JLabel("Name");
		lblNameA.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameA.setBounds(223, 56, 96, 29);
		panel.add(lblNameA);

		JLabel lblAgeA = new JLabel("Age");
		lblAgeA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgeA.setBounds(436, 56, 96, 29);
		panel.add(lblAgeA);

		Username1 = new JTextField();
		Username1.setBounds(95, 56, 116, 67);
		panel.add(Username1);
		Username1.setColumns(10);

		Name1 = new JTextField();
		Name1.setColumns(10);
		Name1.setBounds(300, 60, 116, 22);
		panel.add(Name1);

		City1 = new JTextField();
		City1.setColumns(10);
		City1.setBounds(480, 99, 116, 22);
		panel.add(City1);

		HouseNum1 = new JTextField();
		HouseNum1.setColumns(10);
		HouseNum1.setBounds(300, 99, 116, 22);
		panel.add(HouseNum1);

		Age1 = new JTextField();
		Age1.setColumns(10);
		Age1.setBounds(518, 60, 33, 22);
		panel.add(Age1);

		StreetName1 = new JTextField();
		StreetName1.setColumns(10);
		StreetName1.setBounds(300, 135, 116, 22);
		panel.add(StreetName1);

		JButton Adminsbtn = new JButton("Add");
		Adminsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Administrator admin = new Administrator(Name1.getText(), Integer.parseInt(Age1.getText()),
						PassEnc.encrypt(Username1.getText()), PassEnc.encrypt(Password1.getText()));
				admin.setAddress(new Address(StreetName1.getText(), HouseNum1.getText(), City1.getText()));
				arrayadmins.add(admin);

			}
		});
		Adminsbtn.setBounds(362, 197, 170, 91);
		panel.add(Adminsbtn);

		Password1 = new JPasswordField();
		Password1.setBounds(95, 197, 116, 67);
		panel.add(Password1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add Student", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNameS = new JLabel("Name");
		lblNameS.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameS.setBounds(48, 39, 96, 29);
		panel_2.add(lblNameS);

		JLabel lblAgeS = new JLabel("Age");
		lblAgeS.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgeS.setBounds(173, 39, 96, 29);
		panel_2.add(lblAgeS);

		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGrade.setBounds(48, 130, 96, 29);
		panel_2.add(lblGrade);

		JLabel lblStreetNameS = new JLabel("Street name");
		lblStreetNameS.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreetNameS.setBounds(173, 130, 96, 29);
		panel_2.add(lblStreetNameS);

		JLabel lblCityS = new JLabel("City");
		lblCityS.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityS.setBounds(48, 199, 96, 29);
		panel_2.add(lblCityS);

		JLabel lblHouseNumberS = new JLabel("House Number");
		lblHouseNumberS.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHouseNumberS.setBounds(179, 199, 96, 29);
		panel_2.add(lblHouseNumberS);

		Name2 = new JTextField();
		Name2.setColumns(10);
		Name2.setBounds(43, 75, 116, 22);
		panel_2.add(Name2);

		Grade = new JTextField();
		Grade.setColumns(10);
		Grade.setBounds(58, 164, 65, 22);
		panel_2.add(Grade);

		StreetName2 = new JTextField();
		StreetName2.setColumns(10);
		StreetName2.setBounds(159, 164, 116, 22);
		panel_2.add(StreetName2);

		Age2 = new JTextField();
		Age2.setColumns(10);
		Age2.setBounds(197, 75, 48, 22);
		panel_2.add(Age2);

		City2 = new JTextField();
		City2.setColumns(10);
		City2.setBounds(43, 238, 116, 22);
		panel_2.add(City2);

		HouseNum2 = new JTextField();
		HouseNum2.setColumns(10);
		HouseNum2.setBounds(171, 238, 116, 22);
		panel_2.add(HouseNum2);

		JButton Studentbtn = new JButton("Add");
		Studentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = new Student(Name2.getText(), Integer.parseInt(Age2.getText()),
						Integer.parseInt(Grade.getText()));
				student.setAddress(
						new Address(StreetName2.getText(), HouseNum2.getText(), City2.getText()));
				arraystudents.add(student);
			}
		});
		Studentbtn.setBounds(377, 130, 168, 96);
		panel_2.add(Studentbtn);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Employee", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNameE = new JLabel("Name");
		lblNameE.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameE.setBounds(48, 39, 96, 29);
		panel_1.add(lblNameE);

		JLabel lblAgeE = new JLabel("Age");
		lblAgeE.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgeE.setBounds(187, 39, 96, 29);
		panel_1.add(lblAgeE);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalary.setBounds(37, 131, 96, 29);
		panel_1.add(lblSalary);

		JLabel lblCityE = new JLabel("City");
		lblCityE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityE.setBounds(187, 131, 96, 29);
		panel_1.add(lblCityE);

		JLabel lblStreetNameE = new JLabel("Street name");
		lblStreetNameE.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreetNameE.setBounds(48, 220, 96, 29);
		panel_1.add(lblStreetNameE);

		JLabel lblHouseNumberE = new JLabel("House Number");
		lblHouseNumberE.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHouseNumberE.setBounds(187, 220, 96, 29);
		panel_1.add(lblHouseNumberE);

		Name3 = new JTextField();
		Name3.setBounds(48, 81, 116, 37);
		panel_1.add(Name3);
		Name3.setColumns(10);

		Salary3 = new JTextField();
		Salary3.setColumns(10);
		Salary3.setBounds(48, 167, 79, 22);
		panel_1.add(Salary3);

		StreetName3 = new JTextField();
		StreetName3.setColumns(10);
		StreetName3.setBounds(48, 251, 116, 22);
		panel_1.add(StreetName3);

		Age3 = new JTextField();
		Age3.setColumns(10);
		Age3.setBounds(209, 88, 48, 22);
		panel_1.add(Age3);

		City3 = new JTextField();
		City3.setColumns(10);
		City3.setBounds(187, 167, 96, 22);
		panel_1.add(City3);

		HouseNum3 = new JTextField();
		HouseNum3.setColumns(10);
		HouseNum3.setBounds(187, 251, 116, 22);
		panel_1.add(HouseNum3);

		JButton Employeebtn = new JButton("Add");
		Employeebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee employee = new Employee(Name3.getText(), Integer.parseInt(Age3.getText()),
						Integer.parseInt(Salary3.getText()));
				employee.setAddress(
						new Address(StreetName3.getText(), HouseNum3.getText(), City3.getText()));
				arrayemployees.add(employee);
			}
		});
		Employeebtn.setBounds(368, 142, 165, 93);
		panel_1.add(Employeebtn);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Reports", null, panel_3, null);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Search", null, panel_4, null);
		panel_4.setLayout(null);
	}
}
