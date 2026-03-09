import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIWindow extends JFrame {

    private int count = 0;
    private JLabel txtCounter;

    public GUIWindow(String title) throws HeadlessException {
        super(title);

        JButton btnCounter =  new JButton("Click");
        btnCounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCounter.setText(String.valueOf(++count));
            }
        });

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetCounter();
            }
        });

        Font font = new Font(null, Font.BOLD, 72);
        this.txtCounter = new JLabel(String.valueOf(count), JLabel.CENTER);
        this.txtCounter.setFont(font);
//        this.txtCounter.setHorizontalAlignment(JLabel.CENTER);
//        this.txtCounter.setVerticalAlignment(JLabel.CENTER);
        txtCounter.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeCounterColor();
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(btnReset);
        buttonsPanel.add(btnCounter);

        this.getContentPane().add(txtCounter, BorderLayout.CENTER);
        this.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
//        this.getContentPane().add(btnReset, BorderLayout.SOUTH);
//        this.getContentPane().add(btnCounter, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);   // в центре
//        this.setVisible(true);
    }

    public void resetCounter(){
        i = 0;
        this.count = 0;
        this.txtCounter.setText(String.valueOf(0));
        this.txtCounter.setForeground(Color.BLACK);
    }

    public void changeCounterColor(){
//        // смена фона под текстом
//            txtCounter.setBackground(Color.CYAN);
//            txtCounter.setOpaque(true); // по умолчанию фон прозрачный
        // смена цвета текста
        txtCounter.setForeground(colors[i++ % colors.length]);
    }

    private static int i = 0;
    private static Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
}
