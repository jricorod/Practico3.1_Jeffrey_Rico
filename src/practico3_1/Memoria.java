package practico3_1;

import java.lang.management.MemoryMXBean;
import java.lang.management.ManagementFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Memoria {

    public static void estado() {
        Runtime runtime = Runtime.getRuntime();

        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        long maxMemory = runtime.maxMemory();

        Vista.txtuno.append("\nMaxima   Memoria  :" + (maxMemory / 1024.0) + " KB");
        Vista.txtuno.append("\nTotal Memoria  :" + (totalMemory / 1024.0) + " KB");

        Vista.txtuno.append("\nMemoria Libre  :" + (freeMemory / 1024.0) + " KB");

        Vista.txtuno.append("\nMemoria Usada  :" + (totalMemory / 1024.0 - freeMemory / 1024.0) + " KB");

        Vista.txtuno.append("\n      ********************         ");
        MemoryMXBean mx = ManagementFactory.getMemoryMXBean();

        long initMemory = mx.getHeapMemoryUsage().getInit() + mx.getNonHeapMemoryUsage().getInit();
        long usedMemory = mx.getHeapMemoryUsage().getUsed() + mx.getNonHeapMemoryUsage().getUsed();
        long committedMemory = mx.getHeapMemoryUsage().getCommitted() + mx.getNonHeapMemoryUsage().getCommitted();
        long _maxMemory = mx.getHeapMemoryUsage().getMax() + mx.getNonHeapMemoryUsage().getMax();

        int i = (int) initMemory;

        Vista.txtuno.append("\nMemoria  Maxima:" + (_maxMemory / 1024.0) + " KB");

        Vista.txtuno.append("\nMemoria Comprometida:" + (committedMemory / 1024.0) + " KB");

        Vista.txtuno.append("\n Memoria Inicial:" + (initMemory / 1024.0) + " KB");

        Vista.txtuno.append("\nMemoria Usada:" + (usedMemory / 1024.0) + " KB");

    }

}
