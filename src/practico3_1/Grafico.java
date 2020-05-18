
package practico3_1;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;
import javax.swing.*;
import java.util.Random;

import java.util.Arrays;

public class Grafico {
static void graficatiempo (){
    
    
    Runtime runtime = Runtime.getRuntime();
 
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        long maxMemory = runtime.maxMemory();
 
        System.out.println("Max   Memory  :" + (maxMemory / 1024.0) + " KB");
        
        System.out.println("Total Memory  :" + (totalMemory / 1024.0) + " KB");
        
        System.out.println("Free  Memory  :" + (freeMemory / 1024.0) + " KB");
        
        System.out.println("Used  Memory  :" + (totalMemory / 1024.0 - freeMemory / 1024.0) + " KB");
        
 
        System.out.println("         ===============         ");
        
        MemoryMXBean mx = ManagementFactory.getMemoryMXBean();
 
        long initMemory = mx.getHeapMemoryUsage().getInit() + mx.getNonHeapMemoryUsage().getInit();
        long usedMemory = mx.getHeapMemoryUsage().getUsed() + mx.getNonHeapMemoryUsage().getUsed();
        long committedMemory = mx.getHeapMemoryUsage().getCommitted() + mx.getNonHeapMemoryUsage().getCommitted();
        long _maxMemory = mx.getHeapMemoryUsage().getMax() + mx.getNonHeapMemoryUsage().getMax();
        
        int i = (int) initMemory;
        int f = (int) usedMemory;
        int g = (int) committedMemory;
        int h = (int) _maxMemory;
        int z = (int) freeMemory;
        int y = (int) totalMemory;
       
 
        System.out.println("Max       memory:" + (_maxMemory / 1024.0) + " KB");
        
        System.out.println("Committed memory:" + (committedMemory / 1024.0) + " KB");
        
        System.out.println("Init      memory:" + (initMemory / 1024.0) + " KB");
        
        System.out.println("Used      memory:" + (usedMemory / 1024.0) + " KB");
        
        
        
        
        DefaultCategoryDataset data=new DefaultCategoryDataset ();
        final String corredor1="initMemory";
        final String corredor2="usedMemory";
        final String corredor3="committedMemory";
       
        final String corredor5="freeMemory";
        final String corredor6="totalMemory";
       
     
         
        data.addValue(i, corredor1, "initMemory");
        data.addValue(f, corredor2, "usedMemory");
        data.addValue(g, corredor3, "committedMemory");
       
        data.addValue(z, corredor5, "freeMemory");
        data.addValue(y, corredor6, "totalMemory");
        
        JFreeChart grafica=ChartFactory.createBarChart3D("Grafico de Memoria", "Parametros", "Almacenamiento", data, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel contenedor=new ChartPanel(grafica);
        JFrame ventana=new JFrame("CarreraMotoGp");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(900,800);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
      
         
    }
}