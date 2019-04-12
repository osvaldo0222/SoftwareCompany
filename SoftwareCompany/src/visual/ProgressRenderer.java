package visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

public class ProgressRenderer extends DefaultTableCellRenderer {
	  private final JProgressBar progress = new JProgressBar(0, 100);
	  private final JPanel renderer = new JPanel(new BorderLayout());

	  @Override 
	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	    Integer i = (Integer) value;
	    String text = "Done";
	    if (i < 0) {
	      text = "Canceled";
	    } else if (i <= progress.getMaximum()) { 
	      progress.setValue(i);
	      renderer.add(progress);
	      renderer.setOpaque(false);
	      renderer.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
	      return renderer;
	    }
	    super.getTableCellRendererComponent(table, text, isSelected, hasFocus, row, column);
	    return this;
	  }

	  @Override 
	  public void updateUI() {
	    super.updateUI();
	    setOpaque(false);
	    if (Objects.nonNull(renderer)) {
	      SwingUtilities.updateComponentTreeUI(renderer);
	    }
	  }
}
