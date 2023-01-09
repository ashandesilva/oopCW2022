import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class PatientForm extends JFrame implements ActionListener {
    private Container container;
    private JLabel title;
    private JLabel name;
    private JTextField txtname;
    private JLabel mno;
    private JTextField txtmno;
    private JLabel consultant;
    private JComboBox doc;
    private JLabel bookday;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JButton sub;
    private JButton reset;
    private JLabel alert;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = {"2022", "2023", "2024", "2025", "2026"};

    // constructor, to initialize the components
    // with default values.
    public PatientForm(ArrayList<String> docArray)
    {
        setTitle("Book a Consultation Form");
        setBounds(300, 90, 500, 500);

        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Book a Consultation");
        title.setFont(new Font("SERIF", Font.BOLD, 20));
        title.setSize(200, 30);
        title.setLocation(100, 30);
        container.add(title);

        name = new JLabel("Name:");
        name.setFont(new Font("SERIF", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        container.add(name);

        txtname = new JTextField();
        txtname.setFont(new Font("SERIF", Font.PLAIN, 15));
        txtname.setSize(190, 20);
        txtname.setLocation(200, 100);
        container.add(txtname);

        mno = new JLabel("Mobile No:");
        mno.setFont(new Font("SERIF", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        container.add(mno);

        txtmno = new JTextField();
        txtmno.setFont(new Font("SERIF", Font.PLAIN, 15));
        txtmno.setSize(150, 20);
        txtmno.setLocation(200, 150);
        container.add(txtmno);

        consultant = new JLabel("Consultant: ");
        consultant.setFont(new Font("SERIF", Font.PLAIN, 20));
        consultant.setSize(200, 20);
        consultant.setLocation(100, 190);
        container.add(consultant);

        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < docArray.size(); i++){
            String data = docArray.get(i);
            ArrayList<String> docnames = new ArrayList<>(List.of(data.split(",")));
            String name = docnames.get(0);
            names.add(name);
        }

        doc = new JComboBox(names.toArray());
        doc.setFont(new Font("Arial", Font.PLAIN, 15));
        doc.setSize(100, 20);
        doc.setLocation(250, 195);
        container.add(doc);

        bookday = new JLabel("Consultation Date");
        bookday.setFont(new Font("SERIF", Font.PLAIN, 20));
        bookday.setSize(200, 20);
        bookday.setLocation(100, 240);
        container.add(bookday);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 300);
        container.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(260, 300);
        container.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(330, 300);
        container.add(year);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(130, 370);
        sub.addActionListener(this);
        container.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(250, 370);
        reset.addActionListener(this);
        container.add(reset);

        setVisible(true);

        alert = new JLabel("Consultation Booked");
        alert.setFont(new Font("SERIF", Font.PLAIN, 20));
        alert.setSize(200, 20);
        alert.setLocation(170, 410);
        alert.setVisible(false);
        container.add(alert);
    }

    // method actionPerformed()
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            System.out.println("Consultation Booked");
            //show the submit message
            alert.setVisible(true);
        }
        else if (e.getSource() == reset) {
            String def = "";
            txtname.setText(def);
            txtmno.setText(def);
            doc.setSelectedIndex(0);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            alert.setVisible(false);

        }
    }
}