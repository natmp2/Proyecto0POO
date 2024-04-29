
package itcr.barbero;


public class ClientesMenu extends javax.swing.JFrame {

    
    private BarberoMenu barberoMenu;
    
    public ClientesMenu(BarberoMenu barberoMenu) {
        initComponents();
        this.barberoMenu = barberoMenu;
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        botonCrearCliente = new javax.swing.JButton();
        botonModificarCliente = new javax.swing.JButton();
        botonEliminarCliente = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaClientes = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonCrearCliente.setText("Crear Cliente");
        botonCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearClienteActionPerformed(evt);
            }
        });

        botonModificarCliente.setText("Modificar Cliente");
        botonModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarClienteActionPerformed(evt);
            }
        });

        botonEliminarCliente.setText("Eliminar Cliente");
        botonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarClienteActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListaClientes);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setText("Menu de Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonCrearCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(botonModificarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver)
                    .addComponent(botonCrearCliente)
                    .addComponent(botonModificarCliente)
                    .addComponent(botonEliminarCliente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void botonCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Cliente cliente = new Cliente();
        CrearClienteMenu CCM = new CrearClienteMenu(this);
        CCM.setLocationRelativeTo(this);
        CCM.setVisible(true);
        
        
    }                                                 

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // boton de volver
        this.setVisible(false);
        barberoMenu.setVisible(true);
    }                                           

    private void botonModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void botonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

   

    // Variables declaration - do not modify                     
    private javax.swing.JButton botonCrearCliente;
    private javax.swing.JButton botonEliminarCliente;
    private javax.swing.JButton botonModificarCliente;
    private javax.swing.JButton botonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListaClientes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
