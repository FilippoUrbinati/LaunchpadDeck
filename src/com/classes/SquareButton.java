import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SquareButton extends JButton {
    
    
    
    public SquareButton() {
        
        setPreferredSize(new Dimension(50, 50));
        setBorder(new LineBorder(Color.BLACK, 5));
    
    }
    
    
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
                //apri schermata setting per quel tasto
            }
            if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                //aspetta il click di un altro tasto e scambiali
            }
        }
        public void mouseExited(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
    });
    
    
    
    
}

