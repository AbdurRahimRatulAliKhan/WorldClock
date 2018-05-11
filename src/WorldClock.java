import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.*;

import java.awt.Font;

public class WorldClock {

	private JFrame Frame;
	private JTextField tF1;
	private JTextField tF2;
	private JTextField tF_country;
	private JTextField tF_Capital;
	private JTextField tF_Currency;
	private JTextField tF_UTC;

	int t_h;
	int t_m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldClock window = new WorldClock();
					window.Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WorldClock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Frame = new JFrame();
		Frame.getContentPane().setBackground(Color.PINK);
		Frame.getContentPane().setFont(
				new Font("Times New Roman", Font.BOLD, 25));
		Frame.setResizable(false);
		Frame.setTitle("      \tWorld Clock");
		Frame.setBounds(100, 100, 450, 300);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setLayout(null);
		Frame.setSize(800, 400);

		//TextField to show BD Time
		tF1 = new JTextField();
		tF1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		tF1.setEditable(false);
		tF1.setBounds(26, 93, 151, 45);
		Frame.getContentPane().add(tF1);
		tF1.setColumns(10);

		//Label to show word "Bangladesh"
		JLabel lblBD = new JLabel("Bangladesh");
		lblBD.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblBD.setBounds(26, 11, 157, 36);
		Frame.getContentPane().add(lblBD);

		//Label to show the word "UTC+6" 
		JLabel lblUtcBD = new JLabel(" UTC+6");
		lblUtcBD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUtcBD.setBounds(121, 42, 56, 24);
		Frame.getContentPane().add(lblUtcBD);

		//Label to show Capital Dhaka
		JLabel lbl1 = new JLabel(" Capital: Dhaka");
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl1.setBounds(26, 58, 119, 31);
		Frame.getContentPane().add(lbl1);

		//Button shows the information about developer
		JButton btnAboutDeveloper = new JButton("About Developer");
		btnAboutDeveloper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane
						.showMessageDialog(
								Frame,
								"    Name: Ratul Ali\n    ID: 2161081002\n    Batch: 38th(A)\n    Computer Science & Engineering Department,    \n    Uttara University",
								"About Developer",
								JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAboutDeveloper.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAboutDeveloper.setBounds(641, 28, 126, 36);
		Frame.getContentPane().add(btnAboutDeveloper);

		//This button shows information about UTC/GMT
		JButton btnAboutUtcgmt = new JButton("About UTC/GMT");
		btnAboutUtcgmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane
						.showMessageDialog(
								Frame,
								"Coordinated Universal Time (French: Temps universel coordonné), abbreviated as UTC, is the primary time standard \nby which the world  regulates clocks and  time. It is, within about 1 second, mean solar time at 0° longitude; it does \nnot observe daylight saving time. It is one of several closely related successors to Greenwich Mean Time (GMT). \n\nFor most purposes, UTC is considered interchangeable with GMT, but GMT is no longer precisely defined by the \nscientific community.\n\nFor more detail visit:    https://en.wikipedia.org/wiki/Coordinated_Universal_Time",
								"About UTC/GMT",
								JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAboutUtcgmt.setHorizontalAlignment(SwingConstants.LEFT);
		btnAboutUtcgmt.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAboutUtcgmt.setBounds(491, 28, 133, 36);
		Frame.getContentPane().add(btnAboutUtcgmt);

		//A label that indicates to select a country
		JLabel lblSelectACountry = new JLabel("    Select a Country...");
		lblSelectACountry.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSelectACountry.setBounds(265, 68, 348, 36);
		Frame.getContentPane().add(lblSelectACountry);

		//All countris in array
		String Country[] = { "Afghanistan", "Albania", "Algeria", "Andorra",
				"Angola", "Antigua and Barbuda", "Argentina", "Armenia",
				"Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain",
				"Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
				"Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina",
				"Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso",
				"Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
				"Central African Republic", "Chad", "Chile", "China",
				"Colombia", "Comoros", "Costa Rica", "Croatia", "Cuba",
				"Cyprus", "Czech Republic", "Democratic Republic of the Congo",
				"Djibouti", "Dominica", "Dominican Republic", "East Timor",
				"Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
				"Eritrea", "Estonia", "Ethiopia",
				"Federated States of Micronesia", "Fiji", "Finland", "France",
				"Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece",
				"Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
				"Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland",
				"India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel",
				"Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan",
				"Kazakhstan", "Kenya", "Kingdom of Denmark",
				"Kingdom of the Netherlands", "Kiribati", "Korea, North",
				"Korea, South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos",
				"Latvia", "Lebanon", "Lesotho", "Liberia", "Libya",
				"Liechtenstein", "Lithuania", "Luxembourg", "Macedonia",
				"Madagascar", "Malawi", "Malaysia", "Maldives", "Mali",
				"Malta", "Marshall Islands", "Mauritania", "Mauritius",
				"Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro",
				"Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru",
				"Nepal", "New Zealand", "Nicaragua", "Niger", "Nigeria",
				"Norway", "Oman", "Pakistan", "Palau", "Panama",
				"Papua New Guinea", "Paraguay", "Peru", "Philippines",
				"Poland", "Portugal", "Qatar", "Republic of the Congo",
				"Romania", "Russia", "Rwanda", "Saint Kitts and Nevis",
				"Saint Lucia", "Saint Vincent and the Grenadines", "Samoa",
				"San Marino", "Saudi Arabia", "Senegal", "Serbia",
				"Seychelles", "Sierra Leone", "Singapore", "Slovakia",
				"Slovenia", "Solomon Islands", "Somalia", "South Africa",
				"South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname",
				"Swaziland", "Sweden", "Switzerland", "Syria",
				"São Tomé and Príncipe", "Taiwan", "Tajikistan", "Tanzania",
				"Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia",
				"Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine",
				"United Arab Emirates", "United Kingdom", "United States",
				"Uruguay", "Uzbekistan", "Vanuatu", "Vatican City",
				"Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" };

		//comboBox that have the countries list
		final JComboBox comboBox = new JComboBox(Country);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Sl_Itm = (String) comboBox.getSelectedItem();
				//if any item selected this function sent the selected data in function ComboBox_Selected()
				ComboBox_Selected(Sl_Itm);
			}
		});
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(286, 109, 481, 40);
		Frame.getContentPane().add(comboBox);

		//Clock made using Timer() shows first clock 
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				int x = cal.get(Calendar.HOUR_OF_DAY);
				int y = cal.get(Calendar.MINUTE);
				int z = cal.get(Calendar.SECOND);

				DecimalFormat MF = new DecimalFormat("00");
				String OP1 = MF.format(x);
				String OP2 = MF.format(y);
				String OP3 = MF.format(z);

				tF1.setText(" " + OP1 + ":" + OP2 + ":" + OP3);

			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.start();

		//Initially Show() function is called using Afghanistan  
		Show("Afghanistan", "UTC+04:30", "Kabul", " Afghan afghani", 04, 30);
		St();  //St() function starts the second clock's timer

	}

	// Functions to show output
	public void Show(String Country1, String UTC, String Capital,
			String Currency, int h, int m) {

		tF_Capital = new JTextField(" Capital : " + Capital);
		tF_Capital.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_Capital.setEditable(false);
		tF_Capital.setColumns(10);
		tF_Capital.setBounds(309, 240, 463, 45);
		Frame.getContentPane().add(tF_Capital);

		tF_Currency = new JTextField(" Currency : " + Currency);
		tF_Currency.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_Currency.setEditable(false);
		tF_Currency.setColumns(10);
		tF_Currency.setBounds(309, 293, 463, 45);
		Frame.getContentPane().add(tF_Currency);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(71, 172, 713, 189);
		Frame.getContentPane().add(panel);
		panel.setLayout(null);

		tF_UTC = new JTextField(" " + UTC);
		tF_UTC.setBounds(143, 65, 91, 31);
		panel.add(tF_UTC);
		tF_UTC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tF_UTC.setEditable(false);
		tF_UTC.setColumns(10);

		tF_country = new JTextField(" Now time in " + Country1);
		tF_country.setEditable(false);
		tF_country.setBounds(37, 11, 666, 45);
		panel.add(tF_country);
		tF_country.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tF_country.setColumns(10);

		// textField to show time in selected country
		tF2 = new JTextField();
		tF2.setBounds(37, 107, 151, 45);
		panel.add(tF2);
		tF2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		tF2.setEditable(false);
		tF2.setColumns(10);

		t_h = h;
		t_m = m;
	}

	private void St() {

		// Timer to perform clocking mechanism
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				int x = cal.get(Calendar.HOUR_OF_DAY);
				int y = cal.get(Calendar.MINUTE);
				int z = cal.get(Calendar.SECOND);

				x = x - 6; // Reducing Bangladesh GMT

				// Checking if Hour exceeds adding selected country's GMT/UTC
				if (x + t_h > 23) {
					x = (x + t_h) - 24;
				}

				if (x + t_h < 0) {
					x = x + t_h + 24;
				} else
					x = x + t_h;

				// Checking if Minute exceeds adding selected country's GMT/UTC
				if (y + t_m > 59) {
					y = y + t_m - 60;
					x++;
				} else if (y + t_m < 0) {
					y = y + t_m + 60;
					x--;
				} else
					y = y + t_m;

				// Formatting the clock
				DecimalFormat MF = new DecimalFormat("00");
				String OP1 = MF.format(x);
				String OP2 = MF.format(y);
				String OP3 = MF.format(z);

				// Setting output to clock of selected country
				tF2.setText(" " + OP1 + ":" + OP2 + ":" + OP3);

			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.start();
	}

	// Method to set information about selected country
	public void ComboBox_Selected(String Selected_Item) {
		switch (Selected_Item) {
		case "Afghanistan":
			Show("Afghanistan", "UTC+04:30", "Kabul", " Afghan afghani", 04, 30);
			break;

		case "Albania":
			Show("Albania", "UTC+01:00", "Tirana", "Albanian lek", 01, 00);
			break;
			
		case "Algeria":
			Show("Algeria", "UTC+01:00", "Algiers", "Algerian dinar", 01, 00);
			break;
			
		case "Andorra":
			Show("Andorra","UTC+01:00","Andorra la Vella","Euro",01,00);
			break;
			
		case "Angola":
			Show("Angola","UTC+01:00","Luanda","Angolan kwanza",01,00);
			break;
			
		case "Antigua and Barbuda":
			Show("Antigua and Barbuda","UTC−04:00","St. John's","East Caribbean dollar",-04,00);
			break;
			
		case "Argentina":
			Show("Argentina","UTC−03:00","Buenos Aires","Argentine peso",-03,00);
			break;
			
		case "Armenia":
			Show("Armenia","UTC+04:00","Yerevan","Armenian dram",04,00);
			break;
			
		case "Australia":
			Show("Australia","UTC+10:00","Canberra","Australian dollar",10,00);
			break;
			
		case "Austria":
			Show("Austria","UTC+01:00","Vienna","Euro",01,00);
			break;
			
		case "Azerbaijan":
			Show("Azerbaijan","UTC+04:00","Baku","Azerbaijani manat",04,00);
			break;
			
		case "Bahamas":
			Show("Bahamas","UTC−05:00","Nassau","Bahamian dollar",-05,00);
			break;
			
		case "Bahrain":
			Show("Bahrain","UTC+03:00","Manama","Bahraini dinar",03,00);
			break;
			
		case "Bangladesh":
			Show("Bangladesh","UTC+06:00","Dhaka","Taka",06,00);
			break;
			
		case "Barbados":
			Show("Barbados","UTC−04:00","Bridgetown","Barbadian dollar",-04,00);
			break;
			
		case "Belarus":
			Show("Belarus","UTC+03:00","Minsk","Belarusian ruble",03,00);
			break;
			
		case "Belgium":
			Show("Belgium","UTC+01:00","City of Brussels, Brussels","Euro",01,00);
			break;
			
		case "Belize":
			Show("Belize","UTC−06:00","Belmopan","Belize dollar",-06,00);
			break;
			
		case "Benin":
			Show("Benin","UTC+01:00","Porto-Novo","West African CFA franc",01,00);
			break;

		case "Bhutan":
			Show("Bhutan","UTC+06:00","Thimphu","Bhutanese ngultrum, Indian rupee",06,00);
			break;

		case "Bolivia":
			Show("Bolivia","UTC−04:00","Sucre","Bolivian boliviano",-04,00);
			break;

		case "Bosnia and Herzegovina":
			Show("Bosnia and Herzegovina","UTC+01:00","Sarajevo","Bosnia and Herzegovina convertible mark",01,00);
			break;

		case "Botswana":
			Show("Botswana","UTC+02:00","Gaborone","Pula",02,00);
			break;

		case "Brazil":
			Show("Brazil","UTC−03:00","Brasília","Real",-03,00);
			break;

		case "Brunei":
			Show("Brunei","UTC+08:00","Bandar Seri Begawan","Brunei dollar",8,00);
			break;

		case "Bulgaria":
			Show("Bulgaria","UTC+02:00","Sofia","Lev",02,00);
			break;

		case "Burkina Faso":
			Show("Burkina Faso","UTC (GMT)","Ouagadougou","West African CFA franc",0,0);
			break;

		case "Burundi":
			Show("Burundi","UTC+02:00","Bujumbura","Burundian franc",02,00);
			break;

		case "Cambodia":
			Show("Cambodia","UTC+07:00","Phnom Penh","Cambodian riel",7,0);
			break;

		case "Cameroon":
			Show("Cameroon","UTC+01:00","Yaoundé"," Central African CFA franc",1,0);
			break;

		case "Canada":
			Show("Canada","UTC−05:00","Ottawa","Canadian Dollar ",-5,0);
			break;

		case "Cape Verde":
			Show("Cape Verde","UTC−01:00","Praia","Cape Verdean escudo",-1,0);
			break;

		case "Central African Republic":
			Show("Central African Republic","UTC+01:00","Bangui","Central African CFA franc",01,0);
			break;

		case "Chad":
			Show("Chad","UTC+01:00","N'Djamena","Central African CFA franc",1,0);
			break;

		case "Chile":
			Show("Chile","UTC−03:00","Santiago","Chilean peso",-3,0);
			break;

		case "China":
			Show("China","UTC+08:00","Beijing","Renminbi",8,0);
			break;

		case "Colombia":
			Show("Colombia","UTC−05:00","Bogotá","Colombian peso",-5,0);
			break;

		case "Comoros":
			Show("Comoros","UTC+03:00","Moroni","Comorian franc",3,0);
			break;

		case "Costa Rica":
			Show("Costa Rica","UTC−06:00","San José","Costa Rican colón",-6,0);
			break;

		case "Croatia":
			Show("Croatia","UTC+01:00","Zagreb","Croatian kuna",1,0);
			break;

		case "Cuba":
			Show("Cuba","UTC−05:00","Havana","Cuban peso, Cuban convertible peso",-5,0);
			break;

		case "Cyprus":
			Show("Cyprus","UTC+02:00","Nicosia","Euro",2,0);
			break;

		case "Czech Republic":
			Show("Czech Republic","UTC+01:00","Prague","Czech koruna",1,0);
			break;

		case "Democratic Republic of the Congo":
			Show("Democratic Republic of the Congo","UTC+01:00","Kinshasa","Congolese franc",1,0);
			break;

		case "Djibouti":
			Show("Djibouti","UTC+03:00","Djibouti","Djiboutian franc",3,0);
			break;

		case "Dominica":
			Show("Dominica","UTC−04:00","Roseau","East Caribbean dollar",-4,0);
			break;

		case "Dominican Republic":
			Show("Dominican Republic","UTC−04:00","Santo Domingo"," Dominican peso",-4,0);
			break;

		case "East Timor":
			Show("East Timor","UTC+09:00","Dili","United States Dollar",9,0);
			break;

		case "Ecuador":
			Show("Ecuador","UTC−05:00","Quito","United States Dollar",-5,0);
			break;

		case "Egypt":
			Show("Egypt","UTC+02:00","Cairo","Egyptian pound",2,0);
			break;

		case "El Salvador":
			Show("El Salvador","UTC−06:00","San Salvador","United States Dollar",-6,0);
			break;

		case "Equatorial Guinea":
			Show("Equatorial Guinea","UTC+01:00","Malabo","Central African CFA franc",1,0);
			break;

		case "Eritrea":
			Show("Eritrea","UTC+03:00","Asmara","Eritrean nakfa",3,0);
			break;

		case "Estonia":
			Show("Estonia","UTC+02:00","Tallinn","Euro",2,0);
			break;

		case "Ethiopia":
			Show("Ethiopia","UTC+03:00","Addis Ababa","Ethiopian birr",3,0);
			break;

		case "Federated States of Micronesia":
			Show("Federated States of Micronesia","UTC+11:00","Palikir","United States Dollar",11,0);
			break;

		case "Fiji":
			Show("Fiji","UTC+12:00","Suva","Fijian dollar",12,0);
			break;

		case "Finland":
			Show("Finland","UTC+02:00","Helsinki","Euro",2,0);
			break;

		case "France":
			Show("France","UTC+02:00","Paris","Euro, CFP franc",2,0);
			break;

		case "Gabon":
			Show("Gabon","UTC+01:00","Libreville","Central African CFA franc",1,0);
			break;

		case "Gambia":
			Show("Gambia","UTC (GMT)","Banjul","Gambian dalasi",0,0);
			break;

		case "Georgia":
			Show("Georgia","UTC+04:00","Tbilisi","Georgian lari",4,0);
			break;

		case "Germany":
			Show("Germany","UTC+01:00","Berlin","Euro",1,0);
			break;

		case "Ghana":
			Show("Ghana","UTC (GMT)","Accra","Ghanaian cedi",0,0);
			break;

		case "Greece":
			Show("Greece","UTC+02:00","Athens","Euro",2,0);
			break;

		case "Grenada":
			Show("Grenada","UTC−04:00","St. George's","East Caribbean dollar",-4,0);
			break;

		case "Guatemala":
			Show("Guatemala","UTC−06:00","Guatemala City","Guatemalan quetzal",-6,0);
			break;

		case "Guinea":
			Show("Guinea","UTC (GMT)","Conakry","Guinean Franc",0,0);
			break;

		case "Guinea-Bissau":
			Show("Guinea-Bissau","UTC (GMT)","Bissau","West African CFA franc",0,0);
			break;

		case "Guyana":
			Show("Guyana","UTC−04:00","Georgetown","Guyanese dollar",-4,0);
			break;

		case "Haiti":
			Show("Haiti","UTC−05:00","Port-au-Prince","Haitian gourde",-5,0);
			break;

		case "Honduras":
			Show("Honduras","UTC−06:00","Tegucigalpa","Honduran lempira",-6,0);
			break;

		case "Hong Kong":
			Show("Hong Kong","UTC+08:00","Victoria","Hong Kong dollar",8,0);
			break;

		case "Hungary":
			Show("Hungary","UTC+01:00","Budapest","Hungarian forint",1,0);
			break;

		case "Iceland":
			Show("Iceland","UTC (GMT)","Reykjavik","Icelandic króna",0,0);
			break;

		case "India":
			Show("India","UTC+05:30","New Delhi","Indian rupee",5,30);
			break;

		case "Indonesia":
			Show("Indonesia","UTC+07:00","Jakarta","Indonesian rupiah",7,0);
			break;

		case "Iran":
			Show("Iran","UTC+03:30","Tehran","Iranian rial",3,30);
			break;

		case "Iraq":
			Show("Iraq","UTC+03:00","Baghdad","Iraqi dinar",3,0);
			break;

		case "Ireland":
			Show("Ireland","UTC+01:00","Dublin","Euro",1,0);
			break;

		case "Israel":
			Show("Israel","UTC+02:00","Jerusalem","Israeli new shekel",2,0);
			break;

		case "Italy":
			Show("Italy","UTC+01:00","Rome","Euro",1,0);
			break;

		case "Ivory Coast":
			Show("Ivory Coast","UTC (GMT)","Yamoussoukro","West African CFA franc",0,0);
			break;

		case "Jamaica":
			Show("Jamaica","UTC−05:00","Kingston","Jamaican dollar",-5,0);
			break;

		case "Japan":
			Show("Japan","UTC+09:00","Tokyo","Japanese yen",9,0);
			break;

		case "Jordan":
			Show("Jordan","UTC+02:00","Amman","Jordanian dinar",2,0);
			break;

		case "Kazakhstan":
			Show("Kazakhstan","UTC+06:00","Astana","Kazakhstani tenge",6,0);
			break;

		case "Kenya":
			Show("Kenya","UTC+03:00","Nairobi","Kenyan shilling",3,0);
			break;

		case "Kingdom of Denmark":
			Show("Kingdom of Denmark","UTC+02:00","Copenhagen","Danish krone",2,0);
			break;

		case "Kingdom of the Netherlands":
			Show("Kingdom of the Netherlands","UTC+02:00","Amsterdam","United States Dollar, Euro, Netherlands Antillean guilder, Aruban florin",2,0);
			break;

		case "Kiribati":
			Show("Kiribati","UTC+12:00","South Tarawa","Australian dollar, Kiribati dollar",12,0);
			break;

		case "Korea, North":
			Show("Korea, North","UTC+08:30","Pyongyang","North Korean won",8,30);
			break;

		case "Korea, South":
			Show("Korea, South","UTC+09:00","Seoul","South Korean won",9,0);
			break;

		case "Kosovo":
			Show("Kosovo","UTC+01:00","Pristina","Euro",1,0);
			break;

		case "Kuwait":
			Show("Kuwait","UTC+03:00","Kuwait City","Kuwaiti dinar",3,0);
			break;

		case "Kyrgyzstan":
			Show("Kyrgyzstan","UTC+06:00","Bishkek","Kyrgyzstani som",6,0);
			break;

		case "Laos":
			Show("Laos","UTC+07:00","Vientiane","Lao kip",7,0);
			break;

		case "Latvia":
			Show("Latvia","UTC+02:00","Riga","Euro",2,0);
			break;

		case "Lebanon":
			Show("Lebanon","UTC+02:00","Beirut","Lebanese pound",2,0);
			break;

		case "Lesotho":
			Show("Lesotho","UTC+02:00","Maseru","Lesotho loti",2,0);
			break;

		case "Liberia":
			Show("Liberia","UTC (GMT)","Monrovia","Liberian dollar",0,0);
			break;

		case "Libya":
			Show("Libya","UTC+02:00","Tripoli","Libyan dinar",2,0);
			break;

		case "Liechtenstein":
			Show("Liechtenstein","UTC+01:00","Vaduz","Swiss franc",1,0);
			break;

		case "Lithuania":
			Show("Lithuania","UTC+02:00","Vilnius","Euro",2,0);
			break;

		case "Luxembourg":
			Show("Luxembourg","UTC+01:00","Luxembourg City","Euro",1,0);
			break;

		case "Macedonia":
			Show("Macedonia","UTC+01:00","Skopje","Macedonian denar",1,0);
			break;

		case "Madagascar":
			Show("Madagascar","UTC+03:00 ","Antananarivo","Malagasy ariary",3,0);
			break;

		case "Malawi":
			Show("Malawi","UTC+02:00","Lilongwe","Malawian kwacha",2,0);
			break;

		case "Malaysia":
			Show("Malaysia","UTC+08:00","Kuala Lumpur","Malaysian ringgit",8,0);
			break;

		case "Maldives":
			Show("Maldives","UTC+05:00","Malé","Maldivian rufiyaa",5,0);
			break;

		case "Mali":
			Show("Mali","UTC (GMT)","Bamako","West African CFA franc",0,0);
			break;

		case "Malta":
			Show("Malta","UTC+01:00","Valletta","Euro",1,0);
			break;

		case "Marshall Islands":
			Show("Marshall Islands","UTC+12:00","Majuro","United States Dollar",12,0);
			break;

		case "Mauritania":
			Show("Mauritania","UTC (GMT)","Nouakchott"," Mauritanian ouguiya",0,0);
			break;

		case "Mauritius":
			Show("Mauritius","UTC+04:00","Port Louis","Mauritian rupee",4,0);
			break;

		case "Mexico":
			Show("Mexico","UTC−05:00","Mexico City","Mexican peso",-5,0);
			break;

		case "Moldova":
			Show("Moldova","UTC+02:00","Chișinău","Moldovan leu",2,0);
			break;

		case "Monaco":
			Show("Monaco","UTC+01:00","Monaco","Euro",1,0);
			break;

		case "Mongolia":
			Show("Mongolia","UTC+09:00","Ulaanbaatar","Mongolian tögrög",9,0);
			break;

		case "Montenegro":
			Show("Montenegro","UTC+01:00","Podgorica","Euro",1,0);
			break;

		case "Morocco":
			Show("Morocco","UTC+01:00","Rabat","Moroccan dirham",1,0);
			break;

		case "Mozambique":
			Show("Mozambique","UTC+02:00","Maputo","Metical",2,0);
			break;

		case "Myanmar":
			Show("Myanmar","UTC+06:30","Naypyidaw","Burmese kyat",6,30);
			break;

		case "Namibia":
			Show("Namibia","UTC+01:00","Windhoek","Namibian dollar, South African rand",1,0);
			break;

		case "Nauru":
			Show("Nauru","UTC+12:00","Yaren District","Australian dollar",12,0);
			break;

		case "Nepal":
			Show("Nepal","UTC+05:45","Kathmandu","Nepalese rupee",5,45);
			break;

		case "New Zealand":
			Show("New Zealand","UTC+12:00","Wellington","New Zealand dollar",12,0);
			break;

		case "Nicaragua":
			Show("Nicaragua","UTC−06:00","Managua","Nicaraguan córdoba",-6,0);
			break;

		case "Niger":
			Show("Niger","UTC+01:00","Niamey","West African CFA franc",1,0);
			break;
			
		case "Nigeria":
			Show("Nigeria","UTC+01:00","Abuja","Nigerian naira",1,0);
			break;

		case "Norway":
			Show("Norway","UTC+01:00","Oslo","Norwegian krone",1,0);
			break;

		case "Oman":
			Show("Oman","UTC+04:00","Muscat","Omani rial",4,0);
			break;

		case "Pakistan":
			Show("Pakistan","UTC+05:00","Islamabad","Pakistani rupee",5,0);
			break;

		case "Palau":
			Show("Palau","UTC+09:00","Ngerulmud","United States Dollar",9,0);
			break;

		case "Panama":
			Show("Panama","UTC−05:00","Panama City","United States Dollar, Panamanian balboa",-5,0);
			break;

		case "Papua New Guinea":
			Show("Papua New Guinea","UTC+10:00","Port Moresby","Papua New Guinean kina",10,0);
			break;

		case "Paraguay":
			Show("Paraguay","UTC−04:00","Asunción","Paraguayan guaraní",-4,0);
			break;

		case "Peru":
			Show("Peru","UTC−05:00","Lima","Peruvian nuevo sol",5,0);
			break;

		case "Philippines":
			Show("Philippines","UTC+08:00","Manila","Philippine peso",8,0);
			break;

		case "Poland":
			Show("Poland","UTC+01:00","Warsaw","Polish złoty",1,0);
			break;

		case "Portugal":
			Show("Portugal","UTC+01:00","Lisbon","Euro",1,0);
			break;

		case "Qatar":
			Show("Qatar","UTC+03:00","Doha","Qatari riyal",3,0);
			break;

		case "Republic of the Congo":
			Show("Republic of the Congo","UTC+01:00","Brazzaville","Central African CFA franc",1,0);
			break;

		case "Romania":
			Show("Romania","UTC+02:00","Bucharest","Romanian leu",2,0);
			break;

		case "Russia":
			Show("Russia","UTC+03:00","Moscow","Russian ruble",3,0);
			break;

		case "Rwanda":
			Show("Rwanda","UTC+02:00","Kigali","Rwandan franc",2,0);
			break;

		case "Saint Kitts and Nevis":
			Show("Saint Kitts and Nevis","UTC−04:00","Basseterre","East Caribbean dollar",-4,0);
			break;

		case "Saint Lucia":
			Show("Saint Lucia","UTC−04:00","Castries","East Caribbean dollar",-4,0);
			break;

		case "Saint Vincent and the Grenadines":
			Show("Saint Vincent and the Grenadines","UTC−04:00","Kingstown","East Caribbean dollar",-4,0);
			break;

		case "Samoa":
			Show("Samoa","UTC+13:00","Apia","Samoan tālā",13,0);
			break;

		case "San Marino":
			Show("San Marino","UTC+01:00","San Marino","Euro",1,0);
			break;

		case "Saudi Arabia":
			Show("Saudi Arabia","UTC+03:00","Riyadh","Saudi riyal",3,0);
			break;

		case "Senegal":
			Show("Senegal","UTC (GMT)","Dakar","West African CFA franc",0,0);
			break;

		case "Serbia":
			Show("Serbia","UTC+01:00","Belgrade","Serbian dinar",1,0);
			break;

		case "Seychelles":
			Show("Seychelles","UTC+04:00","Victoria","Seychellois rupee",4,0);
			break;

		case "Sierra Leone":
			Show("Sierra Leone","UTC (GMT)","Freetown","Sierra Leonean leone",0,0);
			break;

		case "Singapore":
			Show("Singapore","UTC+08:00","Singapore city","Singapore dollar",8,0);
			break;

		case "Slovakia":
			Show("Slovakia","UTC+01:00","Bratislava","Euro",1,0);
			break;

		case "Slovenia":
			Show("Slovenia","UTC+01:00","Ljubljana","Euro",1,0);
			break;

		case "Solomon Islands":
			Show("Solomon Islands","UTC+11:00","Honiara","Solomon Islands dollar",11,0);
			break;

		case "Somalia":
			Show("Somalia","UTC+03:00","Mogadishu","Somali shilling",3,0);
			break;

		case "South Africa":
			Show("South Africa","UTC+02:00","Pretoria, Cape Town, Bloemfontein","South African rand",2,0);
			break;

		case "South Sudan":
			Show("South Sudan","UTC+03:00","Juba","South Sudanese pound",3,0);
			break;

		case "Spain":
			Show("Spain","UTC+02:00","Madrid","Euro",2,0);
			break;

		case "Sri Lanka":
			Show("Sri Lanka","UTC+05:30 ","Sri Jayawardenepura Kotte, Colombo","Sri Lankan rupee",5,30);
			break;

		case "Sudan":
			Show("Sudan","UTC+03:00","Khartoum","Sudanese pound",3,0);
			break;

		case "Suriname":
			Show("Suriname","UTC−03:00","Paramaribo","Surinamese dollar",-3,0);
			break;

		case "Swaziland":
			Show("Swaziland","UTC+02:00","Lobamba, Mbabane","Swazi lilangeni, South African rand",2,0);
			break;

		case "Sweden":
			Show("Sweden","UTC+01:00","Stockholm","Swedish krona",1,0);
			break;

		case "Switzerland":
			Show("Switzerland","UTC+01:00","Bern","Swiss franc",1,0);
			break;

		case "Syria":
			Show("Syria","UTC+02:00","Damascus","Syrian pound",2,0);
			break;

		case "São Tomé and Príncipe":
			Show("São Tomé and Príncipe","UTC (GMT)","São Tomé","São Tomé and Príncipe dobra",0,0);
			break;

		case "Taiwan":
			Show("Taiwan","UTC+08:00","Taipei","New Taiwan dollar",8,0);
			break;

		case "Tajikistan":
			Show("Tajikistan","UTC+05:00","Dushanbe","Tajikistani somoni",5,0);
			break;

		case "Tanzania":
			Show("Tanzania","UTC+03:00","Dodoma","Tanzanian shilling",3,0);
			break;

		case "Thailand":
			Show("Thailand","UTC+07:00","Bangkok","Thai baht",7,0);
			break;

		case "Togo":
			Show("Togo","UTC (GMT)","Lomé","CFA franc",0,0);
			break;

		case "Tonga":
			Show("Tonga","UTC+13:00","Nukuʻalofa","Tongan paʻanga",13,0);
			break;

		case "Trinidad and Tobago":
			Show("Trinidad and Tobago","UTC−04:00","Port of Spain","Trinidad and Tobago dollar",-4,0);
			break;

		case "Tunisia":
			Show("Tunisia","UTC+01:00","Tunis","Tunisian dinar",1,0);
			break;

		case "Turkey":
			Show("Turkey","	UTC+02:00","Ankara","Turkish lira",2,0);
			break;

		case "Turkmenistan":
			Show("Turkmenistan","UTC+05:00","Ashgabat","Turkmenistan manat",5,0);
			break;

		case "Tuvalu":
			Show("Tuvalu","UTC+12:00","Funafuti","Australian dollar, Tuvaluan dollar",12,0);
			break;

		case "Uganda":
			Show("Uganda","UTC+03:00","Kampala","Ugandan shilling",3,0);
			break;

		case "Ukraine":
			Show("Ukraine","UTC+02:00","Kiev","Ukrainian hryvnia",2,0);
			break;

		case "United Arab Emirates":
			Show("United Arab Emirates","UTC+04:00","Abu Dhabi","United Arab Emirates dirham",4,0);
			break;

		case "United Kingdom":
			Show("United Kingdom","UTC+01:00","London","Pound sterling",1,0);
			break;

		case "United States":
			Show("United States","UTC-04:00","Washington, D.C.","United States Dollar",4,0);
			break;

		case "Uruguay":
			Show("Uruguay","UTC−03:00","Montevideo","Uruguayan peso",-3,0);
			break;

		case "Uzbekistan":
			Show("Uzbekistan","UTC+05:00","Tashkent","Uzbekistani som",5,0);
			break;

		case "Vanuatu":
			Show("Vanuatu","UTC+11:00","Port Vila","Vanuatu vatu",11,0);
			break;

		case "Vatican City":
			Show("Vatican City","UTC+01:00","Vatican City","Euro",1,0);
			break;

		case "Venezuela":
			Show("Venezuela","UTC−04:30","Caracas","Venezuelan bolívar",-4,30);
			break;

		case "Vietnam":
			Show("Vietnam","UTC+07:00","Hanoi","Vietnamese dong",7,0);
			break;

		case "Yemen":
			Show("Yemen","UTC+03:00","Sana'a","Yemeni rial",3,0);
			break;

		case "Zambia":
			Show("Zambia","UTC+02:00","Lusaka","Zambian kwacha",2,0);
			break;

		case "Zimbabwe":
			Show("Zimbabwe","UTC+02:00","Harare","United States Dollar, Euro, Botswana pula, Pound sterling, South African rand",2,0);
			break;

		default:
			break;
		}
	}
}