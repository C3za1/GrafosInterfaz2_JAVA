
package modificargraf;

import Clases.Arboles;
import Clases.Dibujar;
import Clases.Dijkstra;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

//import javax.swing.JFileChooser;

/**
 *
 * @author cesar
 */
public class Principal extends javax.swing.JFrame 
{
  
  Dibujar pintar =new Dibujar();
  Arboles arboles = new Arboles();
  
  JFileChooser seleccionar=new JFileChooser();//para el mapa
  File archivo;
  byte[] imagen;
  FileInputStream entrada;
  FileOutputStream salida;
  
  public byte[] abrirArchivo(File archivo)
  {
    byte[]imagen=new byte[500000*500000];
    try
    {
       entrada=new FileInputStream(archivo);
       entrada.read(imagen);
    } 
    catch (Exception e) 
    {
    }
    return imagen;
    }
  
   
   public static void R_repaint(int tope, Arboles arboles) //pinta lo q esta antes en el panel 
    {
        for (int j = 0; j < tope; j++) 
        {
            for (int k = 0; k < tope; k++) 
            {
                if(arboles.getmAdyacencia(j, k) == 1)
                     Dibujar.pintarLinea(PanelDibujar.getGraphics(),arboles.getCordeX(j),arboles.getCordeY(j), arboles.getCordeX(k), arboles.getCordeY(k),arboles.getmCoeficiente(j, k));
            }
        }
        for (int j = 0; j < tope; j++) 
            Dibujar.pintarCirculo(PanelDibujar.getGraphics(), arboles.getCordeX(j),arboles.getCordeY(j),String.valueOf(arboles.getNombre(j)));            
    }
 
    public static int ingresarNodoOrigen(String nodoOrige, String noExiste,int tope)
    {
     int nodoOrigen = 0;
        try
        {
            nodoOrigen = Integer.parseInt(JOptionPane.showInputDialog(""+nodoOrige));   
                if(nodoOrigen>=tope)
                {  
                  JOptionPane.showMessageDialog(null,""+noExiste+"\nDebe de ingresar  un Nodo existente");
                  nodoOrigen = ingresarNodoOrigen(nodoOrige,noExiste, tope);
                }
        }
        catch(Exception ex)
        {
           nodoOrigen = ingresarNodoOrigen(nodoOrige,noExiste,tope);
        }
        return nodoOrigen;
    } 

    public  int ingresarTamano(String tama)
    {        
     int tamano = 0;
        try
        {
            tamano = Integer.parseInt(JOptionPane.showInputDialog(""+tama));
            
            if(tamano<1)
            { 
                JOptionPane.showMessageDialog(null,"Debe Ingresar un Tamaño Aceptado..");
                tamano = ingresarTamano(tama);//no es nesario hacer esto
            }
        }
        catch(Exception ex)
        {
            tamano = ingresarTamano(tama);
        }
        return tamano;
    }
 
    public boolean cicDerechoSobreNodo(int xxx,int yyy)
    { 
        for (int j = 0; j < tope; j++) // consultamos si se ha sado  click sobre algun nodo 
        {
            if((xxx+2) > arboles.getCordeX(j) && xxx < (arboles.getCordeX(j)+13) && (yyy+2) > arboles.getCordeY(j) && yyy<(arboles.getCordeY(j)+13) ) 
            {
               if(n==0)
                {
                   id = j;
                   R_repaint(tope,arboles);
                   Dibujar.clickSobreNodo(PanelDibujar.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.orange);       
                   n++;                   
                }
                else
                { 
                   id2=j;                   
                   n++;
                   Dibujar.clickSobreNodo(PanelDibujar.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.orange); 
                   
                   if(id==id2) // si id == id2 por q se volvio a dar click sobre el mismos nodo, se cancela el click anterio
                    {
                       n=0;
                       Dibujar.pintarCirculo(PanelDibujar.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id),String.valueOf(arboles.getNombre(id)));
                       id=-1;
                       id2=-1;
                    }
                } 
              nn=0;
              return true;              
            }
        }
      return false;
    }  
 
    public void clicIzqSobreNodo(int xxx, int yyy)
    {
        for (int j = 0; j <tope; j++) 
        {
            if((xxx+2) > arboles.getCordeX(j) && xxx < (arboles.getCordeX(j)+13) && (yyy+2) > arboles.getCordeY(j) && yyy<(arboles.getCordeY(j)+13) ) 
            {
                if(nn==0)
                {
                   permanente =j; 
                   R_repaint(tope, arboles);                   
                }
               else
                { 
                    nodoFin = j;
                }
                nn++;
                n=0;
                id =-1;
                Dibujar.clickSobreNodo(PanelDibujar.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.GREEN);  
                break;
            }
        }
    }
    
    

    
    public Principal() 
    {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        PesoCaminoCorto = new javax.swing.JTextField();
        btnPesoCamMin = new javax.swing.JButton();
        btnmapa = new javax.swing.JButton();
        PanelDibujar = new javax.swing.JPanel();
        mapa = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        opc = new javax.swing.JMenu();
        Nuevo = new javax.swing.JMenuItem();
        BorrarNodo = new javax.swing.JMenuItem();
        CamCorto = new javax.swing.JMenuItem();
        NuevaArista = new javax.swing.JMenu();
        NewArista = new javax.swing.JMenuItem();
        BorrarArista = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PesoCaminoCorto.setText("$");
        PesoCaminoCorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesoCaminoCortoActionPerformed(evt);
            }
        });

        btnPesoCamMin.setText("Peso del camino Corto es:");
        btnPesoCamMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesoCamMinActionPerformed(evt);
            }
        });

        btnmapa.setText("Mapa");
        btnmapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmapaActionPerformed(evt);
            }
        });

        PanelDibujar.setBackground(new java.awt.Color(204, 204, 204));
        PanelDibujar.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        PanelDibujar.setForeground(new java.awt.Color(255, 255, 255));
        PanelDibujar.setMinimumSize(new java.awt.Dimension(770, 522));
        PanelDibujar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelDibujarMouseMoved(evt);
            }
        });
        PanelDibujar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelDibujarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelDibujarMousePressed(evt);
            }
        });
        PanelDibujar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PanelDibujarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PanelDibujarKeyReleased(evt);
            }
        });
        PanelDibujar.setLayout(null);
        PanelDibujar.add(mapa);
        mapa.setBounds(0, 10, 840, 380);

        opc.setText("Opciones");

        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        opc.add(Nuevo);

        BorrarNodo.setText("Borrar Nodo");
        BorrarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarNodoActionPerformed(evt);
            }
        });
        opc.add(BorrarNodo);

        CamCorto.setText("Camino Corto");
        CamCorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CamCortoActionPerformed(evt);
            }
        });
        opc.add(CamCorto);

        jMenuBar1.add(opc);

        NuevaArista.setText("Arista");
        NuevaArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaAristaActionPerformed(evt);
            }
        });

        NewArista.setText("Nuevo");
        NewArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAristaActionPerformed(evt);
            }
        });
        NuevaArista.add(NewArista);

        BorrarArista.setText("Borrar");
        BorrarArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarAristaActionPerformed(evt);
            }
        });
        NuevaArista.add(BorrarArista);

        jMenuBar1.add(NuevaArista);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmapa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                .addComponent(btnPesoCamMin)
                .addGap(46, 46, 46)
                .addComponent(PesoCaminoCorto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(PanelDibujar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelDibujar, javax.swing.GroupLayout.PREFERRED_SIZE, 392, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesoCaminoCorto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesoCamMin)
                    .addComponent(btnmapa))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelDibujarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDibujarMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelDibujarMouseMoved

    private void PanelDibujarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDibujarMouseClicked
     int xxx, yyy;   
     xxx=evt.getX();
     yyy=evt.getY();
        if(evt.isMetaDown())
        {
          clicIzqSobreNodo(xxx, yyy );     
       
            if(nn==2)
            {
              nn=0;
              Dijkstra Dijkstra = new Dijkstra(arboles,tope,permanente, nodoFin);
              Dijkstra.dijkstra();
              PesoCaminoCorto.setText(""+Dijkstra.getAcumulado());   
            }
        }
        else
        {
            if(!cicDerechoSobreNodo(xxx,yyy))// si  clik sobre  nodo es falso entra
            {
                if(tope<50)
                {
                  arboles.setCordeX(tope,xxx);
                  arboles.setCordeY(tope,yyy);
                  arboles.setNombre(tope, tope);
                  Dibujar.pintarCirculo(PanelDibujar.getGraphics(),arboles.getCordeX(tope), arboles.getCordeY(tope),String.valueOf(arboles.getNombre(tope)));
                  tope++;          
                } 
                else JOptionPane.showMessageDialog(null,"Se ha llegado al Maximo de nodos..");
            } 
            if(n==2 )
            {
              n=0; 
              int  ta = ingresarTamano("Ingrese Tamaño");
              if(aristaMayor < ta) aristaMayor=ta;
              arboles.setmAdyacencia(id2, id, 1);
              arboles.setmAdyacencia(id, id2, 1);
              arboles.setmCoeficiente(id2, id,ta );
              arboles.setmCoeficiente(id, id2, ta);
              Dibujar.pintarLinea(PanelDibujar.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id), arboles.getCordeX(id2), arboles.getCordeY(id2), ta); 
              Dibujar.pintarCirculo(PanelDibujar.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id),String.valueOf(arboles.getNombre(id)));
              Dibujar.pintarCirculo(PanelDibujar.getGraphics(),arboles.getCordeX(id2), arboles.getCordeY(id2),String.valueOf(arboles.getNombre(id2)));
              id=-1;
              id2=-1;
            }
        }
    }//GEN-LAST:event_PanelDibujarMouseClicked

    private void PanelDibujarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDibujarMousePressed
      
        
    }//GEN-LAST:event_PanelDibujarMousePressed

    private void PanelDibujarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelDibujarKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_PanelDibujarKeyPressed

    private void PanelDibujarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelDibujarKeyReleased

    }//GEN-LAST:event_PanelDibujarKeyReleased

    private void PesoCaminoCortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesoCaminoCortoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PesoCaminoCortoActionPerformed

    private void NewAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAristaActionPerformed
     if(tope<=1)
        {
            JOptionPane.showMessageDialog(null,"Cree nuevo nodo : ");
        }
        else
        {
          this.setEnabled(false);
          new VentanaArista(arboles,pintar,tope,this).setVisible(true);
          PanelDibujar.paint(PanelDibujar.getGraphics());
          R_repaint(tope,arboles);        
        }
    }//GEN-LAST:event_NewAristaActionPerformed

    private void BorrarAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarAristaActionPerformed
       // TODO add your handling code here:
        if(tope>=2)
        {
           this.setEnabled(false);
           new EliminarAristas(pintar,arboles,tope,this).setVisible(true);
           PanelDibujar.paint(PanelDibujar.getGraphics());
           R_repaint(tope,arboles); 
        }
        else  JOptionPane.showMessageDialog(null,"No Hay Nodos Enlazados... ");
    }//GEN-LAST:event_BorrarAristaActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
       for (int j = 0; j < tope; j++) 
        {
            arboles.setCordeX(j,0);
            arboles.setCordeY(j,0);              
            arboles.setNombre(j,0);            
        }
        
        for (int j = 0; j < tope; j++) 
        {
            for (int k = 0; k < tope; k++) 
            {
                arboles.setmAdyacencia(j, k, 0);
                arboles.setmCoeficiente(j, k, 0);                 
            }            
        }
     tope=00;   
     PanelDibujar.repaint();
    }//GEN-LAST:event_NuevoActionPerformed

    private void BorrarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarNodoActionPerformed
      int Eliminar= ingresarNodoOrigen("Ingrese Nodo a Eliminar ","Nodo No existe",tope); 
       
        if(Eliminar<=tope && Eliminar>=0 && tope>0)
        {
            for (int j = 0; j < tope; j++) 
            {
                for (int k = 0; k < tope; k++)
                {
                  if(j==Eliminar ||k==Eliminar)
                    {
                       arboles.setmAdyacencia(j, k, -1);                    
                    }
                }
            }
            
            for (int l = 0; l < tope-1; l++) 
            {
                for (int m = 0; m < tope; m++) 
                {
                    if(arboles.getmAdyacencia(l, m)==-1)
                    {
                        arboles.setmAdyacencia(l, m,arboles.getmAdyacencia(l+1, m)); 
                        arboles.setmAdyacencia(l+1, m,-1);
                        arboles.setmCoeficiente(l, m,arboles.getmCoeficiente(l+1, m));
                    }
                }
            }
            
            for (int l = 0; l < tope; l++) 
            {
                for (int m = 0; m < tope-1; m++) 
                {
                    if(arboles.getmAdyacencia(l, m)==-1)
                    {
                        arboles.setmAdyacencia(l, m,arboles.getmAdyacencia(l, m+1)); 
                        arboles.setmAdyacencia(l, m+1,-1);
                        arboles.setmCoeficiente(l, m,arboles.getmCoeficiente(l, m+1));    
                    }
                }
            }
              arboles.setCordeX(Eliminar,-10);
              arboles.setCordeY(Eliminar,-10);
              arboles.setNombre(Eliminar, -10);
            
            for (int j = 0; j < tope; j++) 
            {
                for (int k = 0; k < tope-1; k++) 
                {
                    if(arboles.getCordeX(k)==-10)
                    {
                        arboles.setCordeX(k, arboles.getCordeX(k+1));
                        arboles.setCordeX(k+1, -10);
                        arboles.setCordeY(k, arboles.getCordeY(k+1));
                        arboles.setCordeY(k+1, -10);
                        arboles.setNombre(k, arboles.getNombre(k+1));
                        arboles.setNombre(k+1,-10);
                    }
                }
            }
            
            for (int j = 0; j < tope; j++)   
                arboles.setNombre(j,j);// renombramos             

            for (int j = 0; j < tope+1; j++) // eliminamos los -1 y  los -10 
            {
                for (int k = 0; k < tope+1; k++) 
                {
                    if( arboles.getmAdyacencia(j, k)!=-1)
                    {
                        arboles.setmAdyacencia(j, k, arboles.getmAdyacencia(j, k));
                    }
                    else
                    {
                          arboles.setmAdyacencia(j, k, 0);
                    }
                    
                    if(arboles.getmCoeficiente(j, k) !=-10)
                    {
                        arboles.setmCoeficiente(j, k, arboles.getmCoeficiente(j, k));
                    }
                    else
                    {
                        arboles.setmCoeficiente(j, k, 0);   
                    }
                }         
            }
          tope--;
          PanelDibujar.paint(PanelDibujar.getGraphics());
          R_repaint(tope,arboles);
        }
    }//GEN-LAST:event_BorrarNodoActionPerformed

    private void CamCortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CamCortoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CamCortoActionPerformed

    private void btnPesoCamMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesoCamMinActionPerformed
      if(tope>=2)
       {
        // hacemos el llamano de la funcion
          permanente =  ingresarNodoOrigen("Ingrese Nodo Origen..","nodo Origen No existe",tope);         
          nodoFin =  ingresarNodoOrigen("Ingrese Nodo Fin..","nodo fin No existe",tope);
          Dijkstra Dijkstra = new Dijkstra(arboles,tope,permanente,nodoFin);
          Dijkstra.dijkstra();
          PesoCaminoCorto.setText(""+Dijkstra.getAcumulado());
        }
        else JOptionPane.showMessageDialog(null,"Se deben de crear mas nodos ... ");
    }//GEN-LAST:event_btnPesoCamMinActionPerformed

    private void NuevaAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaAristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevaAristaActionPerformed

    private void btnmapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmapaActionPerformed
JFileChooser Buscar=new JFileChooser();
      FileNameExtensionFilter extension=new FileNameExtensionFilter("Seleccionar imagen", "jpg", "png");
      Buscar.setFileFilter(extension);
      
      if(Buscar.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
      {
          Toolkit tool=Toolkit.getDefaultToolkit();
          String ruta=Buscar.getSelectedFile().toString();
          
          Image imagen=tool.createImage(ruta);
          mapa.setIcon(new ImageIcon(imagen.getScaledInstance(mapa.getWidth(), mapa.getHeight(),Image.SCALE_AREA_AVERAGING)));
      }
//        if(seleccionar.showDialog(null,null)==JFileChooser.APPROVE_OPTION)
//        {
//            archivo=seleccionar.getSelectedFile();
//            if(archivo.canRead())
//            {
//                if(archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")||archivo.getName().endsWith("gif"));
//                imagen=abrirArchivo(archivo);
//                mapa.setIcon(new ImageIcon(imagen));
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null,"archivo no compatible");
//            }
    }//GEN-LAST:event_btnmapaActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
     
    }
    private int tope=0;// lleva el num de nodos creado 
    private int nodoFin;
    private int permanente;
    int n=0,nn=0,id,id2;// permite controlar que se halla dado click sobre un nodo
    private int aristaMayor;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BorrarArista;
    private javax.swing.JMenuItem BorrarNodo;
    private javax.swing.JMenuItem CamCorto;
    private javax.swing.JMenuItem NewArista;
    private javax.swing.JMenu NuevaArista;
    private javax.swing.JMenuItem Nuevo;
    public static javax.swing.JPanel PanelDibujar;
    private javax.swing.JTextField PesoCaminoCorto;
    private javax.swing.JButton btnPesoCamMin;
    private javax.swing.JButton btnmapa;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JLabel mapa;
    private javax.swing.JMenu opc;
    // End of variables declaration//GEN-END:variables
}
