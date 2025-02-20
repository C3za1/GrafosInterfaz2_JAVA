
package Clases;

import java.awt.Color;
import javax.swing.JOptionPane;
import static modificargraf.Principal.R_repaint;

import static modificargraf.Principal.PanelDibujar;
/**
 *
 * @author cesar
 */
public class Dijkstra 
{
   private  Arboles arboles;
   private int tope;
   private int subTope;
   private Nodo auxi=null;
   private int auxAcumulador;
   private int subAcomulado;
   private Nodo nodo[]; 
   private int permanente;     
   private int nodoFin; 
   
   
    public Dijkstra(Arboles arboles, int tope,int permanente, int nodoFin)
    {
        this.arboles = arboles;        
        this.tope = tope;
        this.nodo= new Nodo[tope]; 
        this.permanente = permanente;
        this.nodoFin = nodoFin;    
    }

    public int getAcumulado()
    {
        return nodo[nodoFin].getAcumulado(); 
    }
        
    public void dijkstra()
    { 
        for (int i = 0; i < tope; i++)  // creamos el vector nodo del tamaño de tope el cual tiene el numero de nodo pintados 
        nodo[i]= new Nodo(); 
         
        if(permanente != nodoFin)
        {
            PanelDibujar.paint(PanelDibujar.getGraphics());
            R_repaint(tope, arboles);   
            Dibujar.clickSobreNodo(PanelDibujar.getGraphics(), 
                                   arboles.getCordeX(permanente), 
                                   arboles.getCordeY(permanente), 
                                   null,Color.GREEN); // pinta de color GREEN los nodos
            
            nodo[permanente].setVisitado(true);        
            nodo[permanente].setNombre(permanente);       
            
          do{            
              subAcomulado=0;
              auxAcumulador = 2000000000; // lo igualamos a esta cifra ya q el acomulado de los nodos, nunca sera mayor 
              nodo[permanente].setEtiqueta(true); 
                for (int j = 0; j < tope; j++) 
                {
                    if(arboles.getmAdyacencia(j, permanente)==1)
                    {
                     subAcomulado= nodo[permanente].getAcumulado()+arboles.getmCoeficiente(j, permanente);                                 
                        if(subAcomulado <= nodo[j].getAcumulado() && nodo[j].isVisitado()==true && nodo[j].isEtiqueta()== false)
                        {
                            nodo[j].setAcumulado(subAcomulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[permanente]);
                        }
                        else if( nodo[j].isVisitado()==false)
                        {
                            nodo[j].setAcumulado(subAcomulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[permanente]); 
                        }
                    }
                }
                for (int i = 0; i <tope; i++) // buscamos cual de los nodos visitado tiene el acomulado menor par escogerlo como permanente
                {  
                    if(nodo[i].isVisitado()== true && nodo[i].isEtiqueta()== false)
                    {
                       if(nodo[i].getAcumulado()<=auxAcumulador)
                        {
                          permanente= nodo[i].getNombre();
                          auxAcumulador= nodo[i].getAcumulado();
                        }
                    }               
                }
              subTope++;                
            }
          
            while(subTope<tope+1);          
               auxi= nodo[nodoFin]; 
               if(auxi.getPredecesor() == null )
                  JOptionPane.showMessageDialog(null,"No se Pudo LLegar Al Nodo "+nodoFin);          
               while(auxi.getPredecesor() != null)
                {           
                  Dibujar.pintarCamino(PanelDibujar.getGraphics(), arboles.getCordeX(auxi.getNombre()), arboles.getCordeY(auxi.getNombre()), arboles.getCordeX(auxi.getPredecesor().getNombre()), arboles.getCordeY(auxi.getPredecesor().getNombre()),Color.GREEN);
                  Dibujar.clickSobreNodo(PanelDibujar.getGraphics(), arboles.getCordeX(auxi.getNombre()), arboles.getCordeY(auxi.getNombre()), null,Color.GREEN);
                  auxi=auxi.getPredecesor();              
                }  
          Dibujar.clickSobreNodo(PanelDibujar.getGraphics(), arboles.getCordeX(nodoFin), arboles.getCordeY(nodoFin), null,Color.GREEN);     
       }
       else Dibujar.clickSobreNodo(PanelDibujar.getGraphics(), arboles.getCordeX(nodoFin), arboles.getCordeY(nodoFin), null,Color.GREEN);    
    }
}