import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abv17
 */
public class Interfaz extends javax.swing.JFrame {
    int fila=1;
    int col=1;
    AnalizadorLexico al;
    private boolean guardado= false;
    private JFileChooser fc;
    private ManejadorArchivos ma;
    
    public Interfaz() { 
        al = new AnalizadorLexico();
        areaCodigo = new AreaCodigo();
        initComponents();
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                windowClosingEvent(e);
            }   
        });
        jScrollPane1.setViewportView(areaCodigo);
        update(fila, col);
        fc = new JFileChooser(new File(".").getAbsolutePath());
        fc.setFileFilter(new FileNameExtensionFilter("*.DFN","dfn"));
        
        ma = new ManejadorArchivos();
        
        abrir.setToolTipText("Abrir");
        guardar.setToolTipText("Guardar");
        compilar.setToolTipText("Compilar");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        areaCodigo.setPreferredSize(new Dimension(this.getSize().width, this.getSize().height/2));
        areaCodigo.jTextArea.addCaretListener(new CaretListener(){
            @Override
            public void caretUpdate(CaretEvent ce) {
                JTextArea codigo = (JTextArea)ce.getSource();
                try{
                    int pos =codigo.getCaretPosition();
                    fila=codigo.getLineOfOffset(pos);
                    col = pos-codigo.getLineStartOffset(fila)+1;
                    fila++;
                }catch(Exception e){}
                update(fila, col);
            }
        });
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        areaCodigo.jTextArea.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){           
                 
            } 
            public void keyPressed(KeyEvent evt){
                guardado=false;
            }
            public void keyReleased(KeyEvent evt){
                guardado=false;
            }
        }); 
        areaCodigo.jTextArea.setFont(new Font("Arial", 0, 18));
        AreaComponentesL.setFont(new Font("Arial",0, 16));
        panelPrincipal.setBackground(new Color(237,139,68));
        areaCodigo.jTextArea.requestFocus();
    }
    private void update(int fil, int co){
        numFilas.setText(fil+"");
        numCol.setText(co+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        panelPrincipal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaErrores = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        numFilas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        numCol = new javax.swing.JLabel();
        abrir = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        compilar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreaComponentesL = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        nuevoDoc = new javax.swing.JMenuItem();
        abrirDoc = new javax.swing.JMenuItem();
        guardarDoc = new javax.swing.JMenuItem();
        guardarComo = new javax.swing.JMenuItem();
        editarMenu = new javax.swing.JMenu();
        miBuscar = new javax.swing.JMenuItem();
        miBR = new javax.swing.JMenuItem();
        tablaSimbolosMenu = new javax.swing.JMenu();
        tablaSim = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu7.setText("File");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        AreaErrores.setEditable(false);
        AreaErrores.setColumns(20);
        AreaErrores.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        AreaErrores.setForeground(new java.awt.Color(255, 0, 0));
        AreaErrores.setRows(5);
        AreaErrores.setCaretColor(new java.awt.Color(255, 51, 51));
        jScrollPane2.setViewportView(AreaErrores);

        jLabel2.setText("Fila:");

        jLabel1.setText("Col:");

        abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/folderopened-amarillo-icono-6397-32.png"))); // NOI18N
        abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                abrirMousePressed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/disquetes-excepto-icono-3849-32.png"))); // NOI18N
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guardarMousePressed(evt);
            }
        });

        compilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clicknrun-icono-4776-32.png"))); // NOI18N
        compilar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                compilarMousePressed(evt);
            }
        });

        AreaComponentesL.setEditable(false);
        AreaComponentesL.setColumns(20);
        AreaComponentesL.setRows(5);
        jScrollPane3.setViewportView(AreaComponentesL);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addGap(112, 441, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addComponent(numFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1)
                                        .addGap(25, 25, 25)
                                        .addComponent(numCol, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(119, 119, 119))
                                    .addComponent(jScrollPane3)))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(abrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(compilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(numCol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        archivoMenu.setText("Archivo");

        nuevoDoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        nuevoDoc.setText("Nuevo");
        nuevoDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nuevoDocMousePressed(evt);
            }
        });
        archivoMenu.add(nuevoDoc);

        abrirDoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        abrirDoc.setText("Abrir");
        abrirDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                abrirDocMousePressed(evt);
            }
        });
        archivoMenu.add(abrirDoc);

        guardarDoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        guardarDoc.setText("Guardar");
        guardarDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guardarDocMousePressed(evt);
            }
        });
        archivoMenu.add(guardarDoc);

        guardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        guardarComo.setText("Guardar como...");
        guardarComo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guardarComoMousePressed(evt);
            }
        });
        archivoMenu.add(guardarComo);

        jMenuBar1.add(archivoMenu);

        editarMenu.setText("Editar");

        miBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        miBuscar.setText("Buscar...");
        miBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarActionPerformed(evt);
            }
        });
        editarMenu.add(miBuscar);

        miBR.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        miBR.setText("Buscar/Remplazar");
        miBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBRActionPerformed(evt);
            }
        });
        editarMenu.add(miBR);

        jMenuBar1.add(editarMenu);

        tablaSimbolosMenu.setText("Tabla Simbolos");

        tablaSim.setText("Generar Tabla");
        tablaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablaSimActionPerformed(evt);
            }
        });
        tablaSimbolosMenu.add(tablaSim);

        jMenuBar1.add(tablaSimbolosMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        Dimension dim = this.getContentPane().getSize();
        panelPrincipal.setPreferredSize(dim);
    }//GEN-LAST:event_formComponentResized

    private void miBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarActionPerformed
        VentanaBuscar vb = new VentanaBuscar(this, true,areaCodigo.jTextArea);
        vb.setVisible(true);
    }//GEN-LAST:event_miBuscarActionPerformed

    private void miBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBRActionPerformed
        String cb = showInputDialog(this,"Introduzca la palabra a buscar.");
        if(cb == null){return;}
        String nc = showInputDialog(this,"Introduzca la palabra nueva.");
        if(nc == null){return;}
        areaCodigo.jTextArea.setText(areaCodigo.jTextArea.getText().replaceAll(cb,nc));
    }//GEN-LAST:event_miBRActionPerformed

    private void nuevoDocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoDocMousePressed
        if (!guardado) {
            int opc = javax.swing.JOptionPane.showConfirmDialog(this, "Desea guardar archivo actual?");
            if(opc == JOptionPane.OK_OPTION){
                if(ma.path.equals("")){
                    guardarComo();
                    guardarDoc.setEnabled(false);
                    return;
                }
                guardarDoc.setEnabled(false);
                try{
                    ma.guardar(areaCodigo.jTextArea.getText());
                }catch(IOException err){
                    err.printStackTrace();
                }
            }
            if(opc == JOptionPane.CANCEL_OPTION){
                return;
            }
        }
        guardado=false;
        areaCodigo.jTextArea.setText("");
        ma.path="";
        this.setTitle(ma.path);
    }//GEN-LAST:event_nuevoDocMousePressed

    private void windowClosingEvent(WindowEvent e){
        if (!guardado) {
            int opc = javax.swing.JOptionPane.showConfirmDialog(this, "Desea aguardar archivo actual?");
            if(opc == JOptionPane.OK_OPTION){
                if(ma.path.equals("")){
                    guardarComo();
                    guardarDoc.setEnabled(false);
                    return;
                }
                guardarDoc.setEnabled(false);
                try{
                    ma.guardar(areaCodigo.jTextArea.getText());
                }catch(IOException err){
                    err.printStackTrace();
                }
                System.exit(0);
            }
            if (opc == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }else{
            System.exit(0);
        }
    }
    
    private void abrirDocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirDocMousePressed
        abrir();
        guardado=true;
    }//GEN-LAST:event_abrirDocMousePressed

    private void abrirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMousePressed
        abrir();
        guardado=true;
    }//GEN-LAST:event_abrirMousePressed

    private void guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMousePressed
        if(ma.path.equals("")){
            guardarComo();
            guardado=true;
            return;
        }
        try{
            ma.guardar(areaCodigo.jTextArea.getText());
            guardado=true;
        }catch(IOException err){
            err.printStackTrace();
        }
    }//GEN-LAST:event_guardarMousePressed

    private void compilarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compilarMousePressed
        if(ma.path.equals("")){
            guardarComo();
            guardado=true;
            return;
        }
        try{
            ma.guardar(areaCodigo.jTextArea.getText());
            guardado=true;
        }catch(IOException err){
            err.printStackTrace();
        }
        String [] v = al.compilar(areaCodigo.jTextArea.getText().replaceAll("\t", ""));
        AreaComponentesL.setText(v[0]);
        String errL = v[1];
        AnalizadorSintactico alSinc = new AnalizadorSintactico();
        String errS = alSinc.compilar(al.t);
        AreaErrores.setText(acomodarErr(errL, errS));
        if(AreaErrores.getText().isEmpty()){
            AreaErrores.setForeground(Color.BLUE);
            AreaErrores.setText("Compilado con Exito!!!\n");
            
        }else{
            AreaErrores.setForeground(Color.RED);
            AreaErrores.setText(AreaErrores.getText()+"\nCompilado con Errores");        
        }
    }//GEN-LAST:event_compilarMousePressed

    public String acomodarErr(String err1, String err2){
        String []e1 = (err1+"\n"+err2).split("\n");
        /*
        for(int i = 0; i < e1.length; i++){
            for(int j = 0; j < e1.length && i!= j; j++){
                if(e1[i].substring(e1[i].indexOf(" ")+1,e1[i].indexOf("."))
                        .compareToIgnoreCase(e1[j].substring(e1[i].indexOf(" ")+1,e1[i].indexOf("."))) < 0){
                    String aux = e1[i];
                    e1[i] = e1[j];
                    e1[j] = aux;
                }        
            }
        }*/
        String cad ="";
        for(int i = 0; i < e1.length; i++){
            cad+=e1[i]+"\n";
        }
        return cad;
    }
    private void guardarDocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarDocMousePressed
        guardarMousePressed(null);
    }//GEN-LAST:event_guardarDocMousePressed

    private void guardarComoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarComoMousePressed
        guardarComo();
        guardado=true;
    }//GEN-LAST:event_guardarComoMousePressed

    private void tablaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablaSimActionPerformed
        // TODO add your handling code here:
        try{
            if (al.tablaSimbolos.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this,"La tabla de símbolos esta vacia");
            }else{
                TablaSimbolos tabla = new TablaSimbolos(al.tablaSimbolos);
                tabla.setVisible(true);//Mostramos la tabla de simbolos
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(this,"La tabla de símbolos no ha sido creada");
        }
    }//GEN-LAST:event_tablaSimActionPerformed

    public void abrir(){                
        int r = fc.showOpenDialog(this);
        if(r == JFileChooser.APPROVE_OPTION){
            String path = fc.getSelectedFile().getPath(); 
            setTitle("Archivo: "+path);
            try{
            areaCodigo.jTextArea.setText(ma.abrir(path));
            }catch(IOException e){
                e.printStackTrace();
            }
        }    
    }
        
    public void guardarComo(){
        int r = fc.showSaveDialog(this);
        if(r == JFileChooser.APPROVE_OPTION){
            String path = fc.getSelectedFile().getPath()+".dfn"; 
            setTitle("Archivo: "+path);
            try{
                ma.guardarComo(path, areaCodigo.jTextArea.getText());
            }catch(IOException e){
                e.printStackTrace();
            }
        }  
    }
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    AreaCodigo areaCodigo;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaComponentesL;
    private javax.swing.JTextArea AreaErrores;
    private javax.swing.JButton abrir;
    private javax.swing.JMenuItem abrirDoc;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JButton compilar;
    private javax.swing.JMenu editarMenu;
    private javax.swing.JButton guardar;
    private javax.swing.JMenuItem guardarComo;
    private javax.swing.JMenuItem guardarDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem miBR;
    private javax.swing.JMenuItem miBuscar;
    private javax.swing.JMenuItem nuevoDoc;
    private javax.swing.JLabel numCol;
    private javax.swing.JLabel numFilas;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JMenuItem tablaSim;
    private javax.swing.JMenu tablaSimbolosMenu;
    // End of variables declaration//GEN-END:variables

}
