package airportx;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Vector;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class AirportXUI extends javax.swing.JFrame {

    //Used to track last selected flight in the table
    int selectedFlightId = 0;

    //Used to show the selected airport infos in tables
    String currentAirport = "";
    
    static Clip audioClip=null;

    public AirportXUI() {
        System.out.println("constructor check");
        //Add few example airports
        SystemClass.addAirport(new Airport("IST"));
        SystemClass.addAirport(new Airport("DUB"));
        SystemClass.addAirport(new Airport("CDG"));
        SystemClass.addAirport(new Airport("DXB"));
        SystemClass.addAirport(new Airport("JFK"));
        SystemClass.addAirport(new Airport("YUL"));
        
        //Generate 300 fake flights
        for (int i = 0; i < 300; i++) {
             //System.out.println(i);
            SystemClass.addFlight(DataGen.randomFlight(SystemClass.getAllAirports(), SystemClass.getAllFlights()));
        }
        Collections.sort(SystemClass.getAllFlights());
        initComponents();
        showConfButton.setVisible(false);
        //Add all airpots to the combobox selector so that the user can select an airport to view its flights
        for (int i = 0; i < SystemClass.getAllAirports().size(); i++) {
            airportSelectCombo.addItem(SystemClass.getAllAirports().get(i).getCode());
        }
        tableListeners();
        
        
        
        System.out.println("end constructor check");

    }
    
    /* This method adds 2 listeners to each table(incoming-outgoing)
    *   First: Mouse Listeners, to track double click and display the related detailed flight configuration frame.
    *  Second: List selection listeners, to track what flight was selected and records that flight id to 'selectedFlightId' variable.
    */
    private void tableListeners() {
       
        jTableIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(e.getClickCount());

                if (e.getClickCount() == 2) {
                    System.out.println("Selected Flight id is " + selectedFlightId);
                    (new FlightDetailsFrame(SystemClass.findFlight(selectedFlightId))).setVisible(true);
                }
            }
        });
        //check double click
        jTableOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(e.getClickCount());

                if (e.getClickCount() == 2) {
                    System.out.println("Selected Flight id is " + selectedFlightId);
                    (new FlightDetailsFrame(SystemClass.findFlight(selectedFlightId))).setVisible(true);
                }
            }
        });
        //Necessary flag settings and creation of ListSelectionModel object
        jTableIn.setRowSelectionAllowed(true);
        jTableOut.setRowSelectionAllowed(true);
        ListSelectionModel SelectionModel = jTableIn.getSelectionModel();
        SelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        SelectionModel.addListSelectionListener((ListSelectionEvent e) -> {

            if (e.getValueIsAdjusting()) {
                selectedFlightId = (Integer) jTableIn.getValueAt(jTableIn.getSelectedRow(), 0);
            }

        });
        //Recycle the selectionmodel variable
        SelectionModel = jTableOut.getSelectionModel();

        SelectionModel.addListSelectionListener((ListSelectionEvent e) -> {

            if (e.getValueIsAdjusting()) {
                selectedFlightId = (Integer) jTableOut.getValueAt(jTableOut.getSelectedRow(), 0);
            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableIn = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableOut = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        addFlightButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextA1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextA3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextA5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextA4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextA7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextA6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextA9 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextA2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextA8 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        findFlightButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        updateFlightButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jeflightid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jeCarrier = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jeSource = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jeDest = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jeArriv = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jeDepart = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jeStatus = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jePlane = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jeGate = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        delFlightButton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        findFlightButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        showConfButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        airportSelectCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AirportX - A Global Airport Management System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jTableIn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "Plane ID", "Carrier", "Source", "Destination", "Departure ", "Arrival", "Crew", "Gate ", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableIn.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableIn);
        if (jTableIn.getColumnModel().getColumnCount() > 0) {
            jTableIn.getColumnModel().getColumn(0).setResizable(false);
            jTableIn.getColumnModel().getColumn(1).setResizable(false);
            jTableIn.getColumnModel().getColumn(2).setResizable(false);
            jTableIn.getColumnModel().getColumn(3).setResizable(false);
            jTableIn.getColumnModel().getColumn(4).setResizable(false);
            jTableIn.getColumnModel().getColumn(5).setResizable(false);
            jTableIn.getColumnModel().getColumn(6).setResizable(false);
            jTableIn.getColumnModel().getColumn(7).setResizable(false);
            jTableIn.getColumnModel().getColumn(8).setResizable(false);
            jTableIn.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Incoming ", jPanel1);

        jTableOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "Plane ID", "Carrier", "Source", "Destination", "Departure ", "Arrival", "Crew", "Gate ", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOut.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableOut);
        if (jTableOut.getColumnModel().getColumnCount() > 0) {
            jTableOut.getColumnModel().getColumn(0).setResizable(false);
            jTableOut.getColumnModel().getColumn(1).setResizable(false);
            jTableOut.getColumnModel().getColumn(2).setResizable(false);
            jTableOut.getColumnModel().getColumn(3).setResizable(false);
            jTableOut.getColumnModel().getColumn(4).setResizable(false);
            jTableOut.getColumnModel().getColumn(5).setResizable(false);
            jTableOut.getColumnModel().getColumn(6).setResizable(false);
            jTableOut.getColumnModel().getColumn(7).setResizable(false);
            jTableOut.getColumnModel().getColumn(8).setResizable(false);
            jTableOut.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Outgoing", jPanel2);

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));

        addFlightButton.setText("Add");
        addFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFlightButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Flight ID (100000-99999)");

        jLabel2.setText("Carrier (XXX)");

        jLabel3.setText("Destination (XXX)");

        jLabel4.setText("Source (XXX)");

        jLabel5.setText("Departure (00:00)");

        jLabel6.setText("Arrival (00:00)");

        jLabel7.setText("Status");

        jLabel8.setText("Plane ID (XX-999)");

        jLabel10.setText("Gate (999)");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextA1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(jTextA3)
                        .addComponent(jTextA5)
                        .addComponent(jTextA6))
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(54, 54, 54)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTextA2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextA4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextA8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(139, 139, 139))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextA9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addFlightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextA7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextA8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextA9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(34, 34, 34)))
                        .addComponent(addFlightButton))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextA7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextA6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Add Flight", jPanel8);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setText("Enter Flight ID");

        findFlightButton1.setText("Search");
        findFlightButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFlightButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(findFlightButton1))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findFlightButton1)
                .addGap(23, 23, 23))
        );

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));

        updateFlightButton1.setText("Update Flight");
        updateFlightButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFlightButton1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Flight ID (100000-99999)");

        jLabel14.setText("Carrier (XXX)");

        jLabel15.setText("Destination (XXX)");

        jLabel16.setText("Source (XXX)");

        jLabel17.setText("Departure (00:00)");

        jLabel18.setText("Arrival (00:00)");

        jLabel19.setText("Status");

        jLabel20.setText("Plane ID (XX-999)");

        jLabel21.setText("Gate (999)");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jeflightid, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(jeCarrier)
                        .addComponent(jeSource)
                        .addComponent(jeDepart))
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jePlane, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jeDest, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jeGate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(139, 139, 139))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(updateFlightButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(65, 65, 65))))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jeArriv, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jeflightid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jePlane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jeCarrier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jeGate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jeSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jeDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(34, 34, 34)))
                        .addComponent(updateFlightButton1))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jeArriv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jeDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jTabbedPane2.addTab("Edit Flight", jPanel9);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("Enter Flight ID");

        delFlightButton.setText("Delete");
        delFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delFlightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(delFlightButton))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delFlightButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Delete Flight", jPanel10);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("Enter Flight ID");

        findFlightButton.setText("Search");
        findFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFlightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(findFlightButton))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(findFlightButton)
                .addContainerGap())
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        showConfButton.setText("Flight Configuration");
        showConfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showConfButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(showConfButton)))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(showConfButton)
                        .addGap(0, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Find Flight", jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Flight Operations", jPanel3);

        airportSelectCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airportSelectComboActionPerformed(evt);
            }
        });

        jLabel9.setText("Airport Code");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airportSelectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(384, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(airportSelectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(exitButton)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Settings", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //This method deletes every row of the table that is displayed on the gui so that updated one can be placed
    private void clearTable(DefaultTableModel model) {
        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); ++i) {
                model.removeRow(i);
            }
        }
    }

    //Valides user input and provides error/success messages
    private boolean validateFlight(int flightId, String planeId, String carrier, String dest, String source, String depart, String arriv, int gate, String status,int flag) {
        //Decided to use if checks instead of try/catch since if checks are less resource intensive in this case 
        if (flag==0) {
            if (!(flightId >= 100000 && flightId <= 999999)) {
            //flightId must be unique
            System.out.println("Flight id regex");
            JOptionPane.showMessageDialog(null, "Please enter flightID accordingly(ex./ '100000')", "AirportX", JOptionPane.ERROR_MESSAGE);
            return false;
            }
            if (!(SystemClass.getAllFlights().stream().noneMatch((f) -> (f.getFlightId() == flightId)))) {
                System.out.println("Flight id not unique");
                JOptionPane.showMessageDialog(null, "Matching flightID, please enter a unique ID.", "AirportX", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        

        if ("".equals(planeId) || !planeId.matches("([A-Z][A-Z])(-)+([0-9][0-9][0-9])")) {

            System.out.println("PlaneId regex");
            JOptionPane.showMessageDialog(null, "Please enter planeID accordingly(ex./ 'AA-955')", "AirportX", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if ("".equals(carrier) || !carrier.matches("([A-Z][A-Z][A-Z])")) {

            System.out.println("Carrier regex");
            JOptionPane.showMessageDialog(null, "Please enter carrier accordingly(ex./ 'AAA')", "AirportX", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if ("".equals(dest) || !dest.matches("([A-Z][A-Z][A-Z])")) {

            System.out.println("Destination regex");
            JOptionPane.showMessageDialog(null, "Please enter dest accordingly(ex./ 'AAA')", "AirportX", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if ("".equals(source) || !source.matches("([A-Z][A-Z][A-Z])")) {

            System.out.println("Source regex");
            JOptionPane.showMessageDialog(null, "Please enter source accordingly(ex./ 'AAA')", "AirportX", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if ("".equals(depart) || !depart.matches("([0-9][0-9])(:)+([0-9][0-9])")) {

            System.out.println("Departure time regex");
            JOptionPane.showMessageDialog(null, "Please enter departing time accordingly(ex./ '99:99')", "AirportX", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if ("".equals(arriv) || !arriv.matches("([0-9][0-9])(:)+([0-9][0-9])")) {

            System.out.println("Arrival time regex");
            JOptionPane.showMessageDialog(null, "Please enter arriving time accordingly(ex./ '99:99')", "AirportX", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void addFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFlightButtonActionPerformed

        //Button for submiting a new Flight
        //Used try-catch and an if statement to validate input and respond to user
        try {
            if (validateFlight(Integer.parseInt(jTextA1.getText()), jTextA2.getText(), jTextA3.getText(), jTextA4.getText(), jTextA5.getText(), jTextA6.getText(),
                    jTextA7.getText(), Integer.parseInt(jTextA8.getText()), jTextA9.getText(),0)) {

                SystemClass.addFlight(new Flight(Integer.parseInt(jTextA1.getText()),
                        jTextA2.getText(), jTextA3.getText(), jTextA4.getText(), jTextA5.getText(),
                        jTextA6.getText(), jTextA7.getText(), Integer.parseInt(jTextA8.getText()), jTextA9.getText()));
                JOptionPane.showMessageDialog(null, "Flight Added", "AirportX", JOptionPane.INFORMATION_MESSAGE);
                //if the new flight belongs to current airport, refresh the tables
                if(jTextA4.getText().equalsIgnoreCase(currentAirport) || jTextA5.getText().equalsIgnoreCase(currentAirport)){
                    fillTables();
                }

            }
        } catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Please a valid number", "AirportX", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter fields accordingly", "AirportX", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }


    }//GEN-LAST:event_addFlightButtonActionPerformed

    private void airportSelectComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportSelectComboActionPerformed
        fillTables();
       
    }//GEN-LAST:event_airportSelectComboActionPerformed
    private void fillTables(){
         //Creates a table model, fills it with current flight info depending on the selected airport and puts it on the gui
        DefaultTableModel incomingList = (DefaultTableModel) jTableIn.getModel();
        DefaultTableModel outgoingList = (DefaultTableModel) jTableOut.getModel();
        //Clear previous airport's information 
        clearTable(incomingList);
        clearTable(outgoingList);
        
        //get current airport's code
        currentAirport = SystemClass.getAllAirports().get(airportSelectCombo.getSelectedIndex()).getCode();
        System.out.println("Current Airport : "+currentAirport);

        //get current airport's information
        int index = 0;
        for (Airport airport : SystemClass.getAllAirports()) {
            if (Objects.equals(airport.getCode(), currentAirport)) {
                index = SystemClass.getAllAirports().indexOf(airport);
                break;
            }
        }
        //Put all incoming flights of the current airport into an arraylist
        ArrayList<Flight> arrs = SystemClass.getAllAirports().get(index).incoming(SystemClass.getAllFlights());

        //Add all incoming flights to table row by row
        for (Flight arr : arrs) {
            //Add every column into a vector 
            Vector newRow = new Vector();

            newRow.add(arr.getFlightId());
            newRow.add(arr.getPlaneId());
            newRow.add(arr.getCarrier());
            newRow.add(arr.getSource());
            newRow.add(arr.getDest());
            newRow.add(arr.getDepart());
            newRow.add(arr.getArriv());
            newRow.add("crew");
            newRow.add(arr.getGate());
            newRow.add(arr.getStatus());
            //add the vector to table
            incomingList.addRow(newRow);

        }

        //do the same thing for outgoing flights
        arrs = SystemClass.getAllAirports().get(index).outgoing(SystemClass.getAllFlights());

        for (Flight arr : arrs) {

            Vector newRow = new Vector();

            newRow.add(arr.getFlightId());
            newRow.add(arr.getPlaneId());
            newRow.add(arr.getCarrier());
            newRow.add(arr.getSource());
            newRow.add(arr.getDest());
            newRow.add(arr.getDepart());
            newRow.add(arr.getArriv());
            newRow.add("Click to View");
            newRow.add(arr.getGate());
            newRow.add(arr.getStatus());

            outgoingList.addRow(newRow);

        }


    }
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void findFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFlightButtonActionPerformed
        
        showConfButton.setVisible(false);
        Flight f=null;
        
        try{
        f = SystemClass.findFlight(Integer.parseInt(jTextField1.getText()));
          //Dısplay flight info or error message accordingly
        if (f!=null) {
            jTextArea1.setText(f.toString());
            showConfButton.setVisible(true);
            selectedFlightId = Integer.parseInt(jTextField1.getText());
        }else jTextArea1.setText("Flight not found.");
        }catch(NumberFormatException e){
            
            JOptionPane.showMessageDialog(null, "Please a valid Flight ID", "AirportX", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
      
        
    }//GEN-LAST:event_findFlightButtonActionPerformed

    private void showConfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showConfButtonActionPerformed
        
        (new FlightDetailsFrame(SystemClass.findFlight(selectedFlightId))).setVisible(true);
        
    }//GEN-LAST:event_showConfButtonActionPerformed

    private void delFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delFlightButtonActionPerformed
        Flight f=null;
        
        try{
        f = SystemClass.findFlight(Integer.parseInt(jTextField2.getText()));
        if (f!=null) {
            SystemClass.deleteFlight(Integer.parseInt(jTextField2.getText()));
            JOptionPane.showMessageDialog(null, "Flight Deleted", "AirportX", JOptionPane.INFORMATION_MESSAGE);
            jTextField2.setText("");
            //if the new flight belongs to current airport, refresh the tables
            if (f.getSource().equalsIgnoreCase(currentAirport) || f.getDest().equalsIgnoreCase(currentAirport)) {
                fillTables();
            }
            
        }else JOptionPane.showMessageDialog(null, "Flight not found.", "AirportX", JOptionPane.ERROR_MESSAGE);
        }catch(NumberFormatException e){
            
            JOptionPane.showMessageDialog(null, "Please a valid Flight ID", "AirportX", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        //Dısplay flight info or error message accordingly
        
    }//GEN-LAST:event_delFlightButtonActionPerformed

    private void updateFlightButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFlightButton1ActionPerformed
        Flight f = null;
        //Button for updating a Flight
        //Used try-catch and an if statement to validate input and respond to user
        try {
            f = SystemClass.findFlight(Integer.parseInt(jeflightid.getText()));
            //check if given flight is found
                if (f!=null) {
                    //validate input fields
                    if (validateFlight(-1, jePlane.getText(), jeCarrier.getText(), jeDest.getText(), jeSource.getText(), jeDepart.getText(),
                        jeArriv.getText(), Integer.parseInt(jeGate.getText()), jeStatus.getText(),1)) {

                        f.setPlaneId(jePlane.getText());
                        f.setCarrier(jeCarrier.getText());
                        f.setDest(jeDest.getText());
                        f.setSource(jeSource.getText());
                        f.setDepart(jeDepart.getText());
                        f.setArriv(jeArriv.getText());
                        f.setGate(Integer.parseInt(jeGate.getText()));
                        f.setStatus(jeStatus.getText());
                        
                        JOptionPane.showMessageDialog(null, "Flight Updated", "AirportX", JOptionPane.INFORMATION_MESSAGE);
                        
                        //if the new flight belongs to current airport, refresh the tables
                        if(jeDest.getText().equalsIgnoreCase(currentAirport) || jeSource.getText().equalsIgnoreCase(currentAirport)){
                            fillTables();
                        }
                }
            }
        } catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Please a valid number", "AirportX", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter fields accordingly", "AirportX", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }

        
        
        
    }//GEN-LAST:event_updateFlightButton1ActionPerformed

    private void findFlightButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFlightButton1ActionPerformed
        Flight f = null;
        
        try{
        f = SystemClass.findFlight(Integer.parseInt(jTextField3.getText()));
        //check if given flight exists
        if (f!=null) {
            jeflightid.setText(String.valueOf(f.getFlightId()));
            jeflightid.setEditable(false);
            jeCarrier.setText(f.getCarrier());
            jeSource.setText(f.getSource());
            jeDest.setText(f.getDest());
            jeArriv.setText(f.getArriv());
            jeDepart.setText(f.getDepart());
            jeStatus.setText(f.getStatus());
            jePlane.setText(f.getPlaneId());
            jeGate.setText(String.valueOf(f.getGate()));
            
        }else JOptionPane.showMessageDialog(null, "Flight not found.", "AirportX", JOptionPane.ERROR_MESSAGE);
        }catch(NumberFormatException e){
            
            JOptionPane.showMessageDialog(null, "Please a valid Flight ID", "AirportX", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_findFlightButton1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
       //System.out.println(evt.getKeyCode());
       //Press F1 to stop music, press F2 to continue
        if (evt.getKeyCode()==112) {
            audioClip.stop();
        }else if(evt.getKeyCode()==113) audioClip.loop(30);
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AirportXUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AirportXUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AirportXUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AirportXUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        System.out.println("Start ");
        
        //Create required objects for music player and start looping it
        try {
            File file = new File("Gui_Music.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.open(audioStream);
            //audioClip.start();
            audioClip.loop(30);
            
        } catch (Exception e) {
            System.out.println("Sound file error\n"+e);

        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Create and display ");
                new AirportXUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFlightButton;
    private javax.swing.JComboBox<String> airportSelectCombo;
    private javax.swing.JButton delFlightButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton findFlightButton;
    private javax.swing.JButton findFlightButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableIn;
    private javax.swing.JTable jTableOut;
    private javax.swing.JTextField jTextA1;
    private javax.swing.JTextField jTextA2;
    private javax.swing.JTextField jTextA3;
    private javax.swing.JTextField jTextA4;
    private javax.swing.JTextField jTextA5;
    private javax.swing.JTextField jTextA6;
    private javax.swing.JTextField jTextA7;
    private javax.swing.JTextField jTextA8;
    private javax.swing.JTextField jTextA9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jeArriv;
    private javax.swing.JTextField jeCarrier;
    private javax.swing.JTextField jeDepart;
    private javax.swing.JTextField jeDest;
    private javax.swing.JTextField jeGate;
    private javax.swing.JTextField jePlane;
    private javax.swing.JTextField jeSource;
    private javax.swing.JTextField jeStatus;
    private javax.swing.JTextField jeflightid;
    private javax.swing.JButton showConfButton;
    private javax.swing.JButton updateFlightButton1;
    // End of variables declaration//GEN-END:variables
}
