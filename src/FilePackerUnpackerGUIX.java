import javax.swing.*;
import java.awt.*;
import java.io.File;

class FilePackerUnpackerGUIX
{
    JFrame frame;

    FilePackerUnpackerGUIX()
    {
        frame = new JFrame("File Packer - Unpacker");

        frame.setSize(1000, 650);
        frame.setMinimumSize(new Dimension(900, 600));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);


        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel = new JPanel(new BorderLayout(20, 15));

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 30, 15, 30)
        );


        // =====================================================
        // HEADER
        // =====================================================

        JPanel headingPanel = new JPanel();

        headingPanel.setLayout(
            new BoxLayout(headingPanel, BoxLayout.Y_AXIS)
        );

        JLabel title =
            new JLabel("FILE PACKER - UNPACKER");

        title.setFont(
            new Font("Arial", Font.BOLD, 28)
        );

        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel subtitle =
            new JLabel("File Management Utility");

        subtitle.setFont(
            new Font("Arial", Font.PLAIN, 16)
        );

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        headingPanel.add(title);
        headingPanel.add(Box.createVerticalStrut(5));
        headingPanel.add(subtitle);


        // =====================================================
        // CENTER PANEL
        // =====================================================

        JPanel centerPanel =
            new JPanel(new GridLayout(1, 2, 35, 0));


        // =====================================================
        // PACKER PANEL
        // =====================================================

        JPanel packerPanel =
            new JPanel(new GridBagLayout());

        packerPanel.setBorder(
            BorderFactory.createTitledBorder("PACKER")
        );

        packerPanel.setBackground(
            new Color(235, 242, 250)
        );


        GridBagConstraints gbc =
            new GridBagConstraints();

        gbc.insets =
            new Insets(15, 15, 15, 15);

        gbc.fill =
            GridBagConstraints.HORIZONTAL;


        // Folder Label

        JLabel folderLabel =
            new JLabel("Folder :");

        folderLabel.setFont(
            new Font("Arial", Font.BOLD, 14)
        );


        // Folder TextField

        JTextField folderText =
            new JTextField();

        folderText.setPreferredSize(
            new Dimension(250, 32)
        );


        // Folder Browse Button

        JButton folderBrowse =
            new JButton("Browse");

        folderBrowse.setPreferredSize(
            new Dimension(100, 32)
        );


        // Add Folder Label

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        packerPanel.add(
            folderLabel,
            gbc
        );


        // Add Folder TextField

        gbc.gridx = 1;
        gbc.weightx = 1;

        packerPanel.add(
            folderText,
            gbc
        );


        // Add Folder Browse

        gbc.gridx = 2;
        gbc.weightx = 0;

        packerPanel.add(
            folderBrowse,
            gbc
        );


        // =====================================================
        // Pack File
        // =====================================================

        JLabel packLabel =
            new JLabel("Pack File :");

        packLabel.setFont(
            new Font("Arial", Font.BOLD, 14)
        );


        JTextField packText =
            new JTextField();

        packText.setPreferredSize(
            new Dimension(250, 32)
        );


        JButton packFileBrowse =
            new JButton("Browse");

        packFileBrowse.setPreferredSize(
            new Dimension(100, 32)
        );


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        packerPanel.add(
            packLabel,
            gbc
        );


        gbc.gridx = 1;
        gbc.weightx = 1;

        packerPanel.add(
            packText,
            gbc
        );


        gbc.gridx = 2;
        gbc.weightx = 0;

        packerPanel.add(
            packFileBrowse,
            gbc
        );


        // =====================================================
        // PACK Button
        // =====================================================

        JButton packButton =
            new JButton("PACK");

        packButton.setPreferredSize(
            new Dimension(150, 45)
        );


        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.gridwidth = 1;

        gbc.anchor =
            GridBagConstraints.CENTER;

        gbc.fill =
            GridBagConstraints.NONE;

        gbc.insets =
            new Insets(30, 15, 15, 15);

        packerPanel.add(
            packButton,
            gbc
        );


        // =====================================================
        // UNPACKER PANEL
        // =====================================================

        JPanel unpackerPanel =
            new JPanel(new GridBagLayout());

        unpackerPanel.setBorder(
            BorderFactory.createTitledBorder("UNPACKER")
        );

        unpackerPanel.setBackground(
            new Color(242, 242, 242)
        );


        GridBagConstraints ug =
            new GridBagConstraints();

        ug.insets =
            new Insets(15, 15, 15, 15);

        ug.fill =
            GridBagConstraints.HORIZONTAL;


        // =====================================================
        // Packed File
        // =====================================================

        JLabel packedLabel =
            new JLabel("Packed File :");

        packedLabel.setFont(
            new Font("Arial", Font.BOLD, 14)
        );


        JTextField packedText =
            new JTextField();

        packedText.setPreferredSize(
            new Dimension(250, 32)
        );


        JButton packedBrowse =
            new JButton("Browse");

        packedBrowse.setPreferredSize(
            new Dimension(100, 32)
        );


        ug.gridx = 0;
        ug.gridy = 0;
        ug.weightx = 0;

        unpackerPanel.add(
            packedLabel,
            ug
        );


        ug.gridx = 1;
        ug.weightx = 1;

        unpackerPanel.add(
            packedText,
            ug
        );


        ug.gridx = 2;
        ug.weightx = 0;

        unpackerPanel.add(
            packedBrowse,
            ug
        );


        // =====================================================
        // UNPACK Button
        // =====================================================

        JButton unpackButton =
            new JButton("UNPACK");

        unpackButton.setPreferredSize(
            new Dimension(150, 45)
        );


        ug.gridx = 1;
        ug.gridy = 1;

        ug.anchor =
            GridBagConstraints.CENTER;

        ug.fill =
            GridBagConstraints.NONE;

        ug.insets =
            new Insets(30, 15, 15, 15);

        unpackerPanel.add(
            unpackButton,
            ug
        );


        // =====================================================
        // Add panels
        // =====================================================

        centerPanel.add(packerPanel);
        centerPanel.add(unpackerPanel);


        // =====================================================
        // STATUS
        // =====================================================

        JLabel statusLabel =
            new JLabel("Status : Ready");

        statusLabel.setFont(
            new Font("Arial", Font.BOLD, 14)
        );


        // =====================================================
        // FOOTER
        // =====================================================

        JLabel footer =
            new JLabel(
                "Java File Packer-Unpacker | XOR Encryption"
            );

        footer.setFont(
            new Font("Arial", Font.ITALIC, 12)
        );

        footer.setHorizontalAlignment(
            SwingConstants.CENTER
        );


        // =====================================================
        // Bottom Panel
        // =====================================================

        JPanel bottomPanel =
            new JPanel(new BorderLayout());

        bottomPanel.add(
            statusLabel,
            BorderLayout.WEST
        );

        bottomPanel.add(
            footer,
            BorderLayout.CENTER
        );


        // =====================================================
        // Add to Main Panel
        // =====================================================

        mainPanel.add(
            headingPanel,
            BorderLayout.NORTH
        );

        mainPanel.add(
            centerPanel,
            BorderLayout.CENTER
        );

        mainPanel.add(
            bottomPanel,
            BorderLayout.SOUTH
        );


        // =====================================================
        // Add Main Panel to Frame
        // =====================================================

        frame.setContentPane(mainPanel);


        // =====================================================
        // FOLDER BROWSE ACTION
        // =====================================================

        folderBrowse.addActionListener(e ->
        {
            JFileChooser chooser =
                new JFileChooser();

            chooser.setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY
            );

            int result =
                chooser.showOpenDialog(frame);

            if(result ==
                JFileChooser.APPROVE_OPTION)
            {
                File selectedFolder =
                    chooser.getSelectedFile();

                folderText.setText(
                    selectedFolder.getAbsolutePath()
                );
            }
        });


        // =====================================================
        // PACK FILE BROWSE ACTION
        // =====================================================

        packFileBrowse.addActionListener(e ->
        {
            JFileChooser chooser =
                new JFileChooser();

            int result =
                chooser.showSaveDialog(frame);

            if(result ==
                JFileChooser.APPROVE_OPTION)
            {
                File selectedFile =
                    chooser.getSelectedFile();

                packText.setText(
                    selectedFile.getAbsolutePath()
                );
            }
        });


        // =====================================================
        // PACKED FILE BROWSE ACTION
        // =====================================================

        packedBrowse.addActionListener(e ->
        {
            JFileChooser chooser =
                new JFileChooser();

            chooser.setFileSelectionMode(
                JFileChooser.FILES_ONLY
            );

            int result =
                chooser.showOpenDialog(frame);

            if(result ==
                JFileChooser.APPROVE_OPTION)
            {
                File selectedFile =
                    chooser.getSelectedFile();

                packedText.setText(
                    selectedFile.getAbsolutePath()
                );
            }
        });


        // =====================================================
        // PACK BUTTON
        // =====================================================

        packButton.addActionListener(e ->
        {
            String folder =
                folderText.getText().trim();

            String packFile =
                packText.getText().trim();


            if(folder.isEmpty() ||
               packFile.isEmpty())
            {
                JOptionPane.showMessageDialog(
                    frame,
                    "Please select folder and pack file."
                );

                return;
            }


            try
            {
                boolean result =
                    FilePacker.pack(
                        folder,
                        packFile
                    );


                if(result)
                {
                    statusLabel.setText(
                        "Status : Packing completed successfully"
                    );

                    JOptionPane.showMessageDialog(
                        frame,
                        "Packing completed successfully."
                    );
                }
                else
                {
                    statusLabel.setText(
                        "Status : Packing failed"
                    );

                    JOptionPane.showMessageDialog(
                        frame,
                        "Folder does not exist."
                    );
                }
            }
            catch(Exception eobj)
            {
                statusLabel.setText(
                    "Status : Packing failed"
                );

                JOptionPane.showMessageDialog(
                    frame,
                    "Packing failed : "
                    + eobj.getMessage()
                );
            }
        });


        // =====================================================
        // UNPACK BUTTON
        // =====================================================

        unpackButton.addActionListener(e ->
        {
            String packFile =
                packedText.getText().trim();


            if(packFile.isEmpty())
            {
                JOptionPane.showMessageDialog(
                    frame,
                    "Please select a packed file."
                );

                return;
            }


            try
            {
                boolean result =
                    FileUnpacker.unpack(
                        packFile
                    );


                if(result)
                {
                    statusLabel.setText(
                        "Status : Unpacking completed successfully"
                    );

                    JOptionPane.showMessageDialog(
                        frame,
                        "Unpacking completed successfully."
                    );
                }
                else
                {
                    statusLabel.setText(
                        "Status : Unpacking failed"
                    );

                    JOptionPane.showMessageDialog(
                        frame,
                        "Invalid or non-existent packed file."
                    );
                }
            }
            catch(Exception eobj)
            {
                statusLabel.setText(
                    "Status : Unpacking failed"
                );

                JOptionPane.showMessageDialog(
                    frame,
                    "Unpacking failed : "
                    + eobj.getMessage()
                );
            }
        });


        // =====================================================
        // DISPLAY FRAME
        // =====================================================

        frame.setVisible(true);
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String A[])
    {
        new FilePackerUnpackerGUIX();
    }
}