import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class SAQS {
  public static void main(String[] args) {
    final DefaultListModel model = new DefaultListModel();
    final JList list = new JList(model);
    final JList QueueList1 = new JList();
    final JList QueueList2 = new JList();
    JFrame f = new JFrame();
    f.setTitle("S.A.Q.S");
    
    model.addElement("Alpha");
    model.addElement("Bravo");
    model.addElement("Charlie");
    model.addElement("Delta");
    model.addElement("Echo");

    JPanel MainPanel = new JPanel();
    MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
    JPanel TopBar_Panel = new JPanel();
    JPanel WaitingPanel = new JPanel();
    JPanel InputTextPanel = new JPanel();
    JPanel InputPanel = new JPanel();
    JPanel ButtonPanel = new JPanel();
    JPanel MainQueuePanel = new JPanel();
    JPanel QueueOutPanel = new JPanel();
   

    TopBar_Panel.setLayout(new FlowLayout());
    WaitingPanel.setLayout(new BorderLayout());
    InputTextPanel.setLayout(new FlowLayout());
    InputPanel.setLayout(new FlowLayout());
    ButtonPanel.setLayout(new FlowLayout());
    MainQueuePanel.setLayout(new GridLayout());
    QueueOutPanel.setLayout(new FlowLayout());
   
//Anything 
//TopBar_Panel    
    JLabel TopBarLabel = new JLabel("Super Advanced Queue System");
    TopBar_Panel.add(TopBarLabel);

//WaitingPanel
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

    list.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          int index = list.locationToIndex(e.getPoint());
          Object item = model.getElementAt(index);
          String text = JOptionPane.showInputDialog("Rename item", item);
          String newitem = "";
          if (text != null)
            newitem = text.trim();
          else
            return;

          if (!newitem.isEmpty()) {
            model.remove(index);
            model.add(index, newitem);
            ListSelectionModel selmodel = list.getSelectionModel();
            selmodel.setLeadSelectionIndex(index);
          }
        }
      }
    });


    WaitingPanel.add(new JScrollPane(list));

//InputTextPanel
    JLabel NameText = new JLabel("Enter Customer");
    InputTextPanel.add(NameText);
    NameText.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 90));

    JLabel QuantityText = new JLabel("Enter Quantity");
    InputTextPanel.add(QuantityText);
    
    
//InputPanel
    JTextField NameInput = new JTextField(15);
    InputPanel.add(NameInput);
    NameInput.setLocation(100,10);
    JTextField QuantityInput = new JTextField(15);
    InputPanel.add(QuantityInput);
    
    
//ButtonPanel    
    JButton removeall = new JButton("Remove All");
    JButton add = new JButton("Add");
    JButton rename = new JButton("Rename");
    JButton delete = new JButton("Delete");
    
 

    ButtonPanel.add(add);
    ButtonPanel.add(rename);
    ButtonPanel.add(delete);
    ButtonPanel.add(removeall);
    
//MainQueuePanel
    MainQueuePanel.add(new JScrollPane(QueueList1));
    MainQueuePanel.add(new JScrollPane(QueueList2));
    
//QueueOutPanel
    JButton QueueOut1 = new JButton("Queue 1 Out");
    QueueOutPanel.add(QueueOut1);
    JButton QueueOut2 = new JButton("Queue 2 Out");
    QueueOutPanel.add(QueueOut2);

    
    MainPanel.add(TopBar_Panel);
    MainPanel.add(WaitingPanel);
    MainPanel.add(InputTextPanel);
    MainPanel.add(InputPanel);
    MainPanel.add(ButtonPanel);
    MainPanel.add(MainQueuePanel);
    MainPanel.add(QueueOutPanel);

    f.add(MainPanel);

    f.setSize(600, 700);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);

  }
}