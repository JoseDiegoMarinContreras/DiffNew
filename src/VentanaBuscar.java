
import javax.swing.JTextPane;
import static javax.swing.JOptionPane.showMessageDialog;



public class VentanaBuscar extends javax.swing.JDialog {
    private JTextPane c;
    private  int index,indexr;
    /**
     * Creates new form VentanaBuscar
     */
    public VentanaBuscar(java.awt.Frame parent, boolean modal, JTextPane c) {
        super(parent, modal);
        initComponents();
        this.c = c;
        index = -1;
        indexr = -1;
        setResizable(false);
        this.setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnSig = new javax.swing.JButton();
        btnAnt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar...");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Buscar:");

        txtBuscar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        btnSig.setText("Siguiente");
        btnSig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSigMouseClicked(evt);
            }
        });

        btnAnt.setText("Anterior");
        btnAnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAntMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnt))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSig)
                    .addComponent(btnAnt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSigMouseClicked
        String pb = txtBuscar.getText();
        if(pb.length() > c.getText().length()){
            showMessageDialog(this,"No existen coincidencias");
            return;
        }
        if(index == c.getText().length()-pb.length()+1 && indexr >= 0){
            index = indexr;
            indexr = -1;        
        }
        for(int i = (index+1);i <= (c.getText().length()-pb.length()) ;i++){
            index = i;
            if(c.getText().substring(i, i+pb.length()).equals(pb)){
                c.setSelectionStart(i);
                c.setSelectionEnd(i+pb.length());
                indexr = index;
                return;
            }
        }
        indexr = index;
        index = -1;
        showMessageDialog(this,"No existen mas coincidencias");
    }//GEN-LAST:event_btnSigMouseClicked

    private void btnAntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAntMouseClicked
        String pb = txtBuscar.getText();
        if(pb.length() > c.getText().length()){
            showMessageDialog(this,"No existen coincidencias");
            return;
        }
        if(index < 0 && indexr == -1){
            index = c.getText().length()-pb.length()+1;
        }else if(index < 0 && indexr >= 0){
            index = indexr;
            indexr = -1;        
        }
        for(int i = (index-1);i >= 0;i--){
            index = i;
            if(c.getText().substring(i, i+pb.length()).equals(pb)){
                c.setSelectionStart(i);
                c.setSelectionEnd(i+pb.length());
                indexr = index;
                return;
            }
        }
        indexr = index;
        index = c.getText().length()-pb.length()+1;
        showMessageDialog(this,"No existen mas coincidencias");
    }//GEN-LAST:event_btnAntMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnt;
    private javax.swing.JButton btnSig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
