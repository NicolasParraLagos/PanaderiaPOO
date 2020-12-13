import javax.swing.*;
import java.sql.ResultSet;


public class Principal extends javax.swing.JFrame {
    
    Conexion con;
    

    public Principal() {
        initComponents();
        llenarListaProducto();
        llenarListaPedidos();
    }
    

    public void llenarListaProducto(){
        try{
            DefaultListModel mod = new DefaultListModel();
            mod.clear();
            
            String codigo,nombre,tipo,precio,stock,stockCritico,data;
            con = new Conexion();
            ResultSet lista = con.listar("SELECT * FROM productos");
            
            lstProducto.setModel(mod);
            while(lista.next()){
                codigo = lista.getString("codigo");
                while(codigo.length()<9){
                    codigo = codigo + " ";
                }
                nombre = "#" + lista.getString("nombre");
                while(nombre.length()<52){
                    nombre = nombre + " ";
                }
                tipo = "/" + lista.getString("tipo");
                while(tipo.length()<22){
                    tipo = tipo + " ";
                }
                precio = "$" + lista.getString("precio");
                while(precio.length()<13){
                    precio = precio + " ";
                }
                stock = "%" + lista.getString("stock");
                while(stock.length()<7){
                    stock = stock + " ";
                }
                stockCritico = "!" + lista.getString("stockCritico");
                while(stockCritico.length()<7){
                    stockCritico = stockCritico + " ";
                }
                
                data = codigo + nombre + tipo + precio + stock + stockCritico;
                mod.addElement(data);
            }
        
            con.close();
            
        }catch(Exception ex){
            
        }
    }

    public void llenarListaPedidos(){
        try{
            DefaultListModel mod = new DefaultListModel();
            mod.clear();
            
            String numero,rutCliente,estado,data;
            con = new Conexion();
            ResultSet lista = con.listar("SELECT * FROM pedidos");
            
            lstPedido.setModel(mod);
            while(lista.next()){
                numero = lista.getString("numero");
                while(numero.length()<11){
                    numero = numero + " ";
                }
                rutCliente = "#" + lista.getString("rutCliente");
                while(rutCliente.length()<16){
                    rutCliente = rutCliente + " ";
                }
                estado = "!" + lista.getString("estado");
                while(estado.length()<16){
                    estado = estado + " ";
                }
                
                data = numero + rutCliente + estado;
                mod.addElement(data);
            }
            
            con.close();
            
        }catch(Exception ex){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgEstado = new javax.swing.ButtonGroup();
        lblProducto = new javax.swing.JLabel();
        lblCodProducto = new javax.swing.JLabel();
        lblNomProducto = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        txtNomProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtStockCritico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProducto = new javax.swing.JList<>();
        cmdNuevoProducto = new javax.swing.JButton();
        cmdModificarProducto = new javax.swing.JButton();
        cmdEliminarProducto = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        lblBuscarProducto = new javax.swing.JLabel();
        cmbBuscarProducto = new javax.swing.JComboBox<>();
        lblTipo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPedido = new javax.swing.JList<>();
        lblPedido = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        txtRutCliente = new javax.swing.JTextField();
        lblRutCliente = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        cmdNuevoPedido = new javax.swing.JButton();
        cmdModificarPedido = new javax.swing.JButton();
        cmdEliminarPedido = new javax.swing.JButton();
        lblBuscarPedido = new javax.swing.JLabel();
        txtBuscarPedido = new javax.swing.JTextField();
        cmbBuscarPedido = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        lblStockCritico = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        rbPendiente = new javax.swing.JRadioButton();
        rbListo = new javax.swing.JRadioButton();
        rbCancelado = new javax.swing.JRadioButton();
        lblEstado = new javax.swing.JLabel();
        cmdSalir = new javax.swing.JButton();
        cmdClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProducto.setText("PRODUCTO");

        lblCodProducto.setText("Codigo");

        lblNomProducto.setText("Nombre");

        lblPrecio.setText("Precio");

        lblStock.setText("Stock");

        lstProducto.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        lstProducto.setToolTipText("");
        lstProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstProducto);

        cmdNuevoProducto.setText("Insertar");
        cmdNuevoProducto.setToolTipText("Insertar en la base de datos");
        cmdNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNuevoProductoActionPerformed(evt);
            }
        });

        cmdModificarProducto.setText("Modificar");
        cmdModificarProducto.setToolTipText("Seleccione el item de la lista que quiera modificar");
        cmdModificarProducto.setEnabled(false);

        cmdEliminarProducto.setText("Eliminar");
        cmdEliminarProducto.setToolTipText("Seleccione el item de la lista que quiera eliminar");
        cmdEliminarProducto.setEnabled(false);

        lblBuscarProducto.setText("Buscar");

        cmbBuscarProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Tipo", "Precio", "Stock", "Stock Critico" }));

        lblTipo.setText("Tipo");

        lstPedido.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        lstPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstPedido);

        lblPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPedido.setText("PEDIDO");

        lblNum.setText("Numero Pedido");

        lblRutCliente.setText("Rut Cliente");

        lblDescripcion.setText("Descipción");

        cmdNuevoPedido.setText("Insertar");
        cmdNuevoPedido.setToolTipText("Insertar en la base de datos");
        cmdNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNuevoPedidoActionPerformed(evt);
            }
        });

        cmdModificarPedido.setText("Modificar");
        cmdModificarPedido.setToolTipText("Seleccione el item de la lista que quiera modificar");
        cmdModificarPedido.setEnabled(false);

        cmdEliminarPedido.setText("Eliminar");
        cmdEliminarPedido.setToolTipText("Seleccione el item de la lista que quiera eliminar");
        cmdEliminarPedido.setEnabled(false);

        lblBuscarPedido.setText("Buscar");

        cmbBuscarPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero", "Rut" }));

        lblStockCritico.setText("Stock Critico");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pan", "Pastel" }));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane3.setViewportView(txtDescripcion);

        bgEstado.add(rbPendiente);
        rbPendiente.setText("Pendiente");

        bgEstado.add(rbListo);
        rbListo.setText("Listo");

        bgEstado.add(rbCancelado);
        rbCancelado.setText("Cancelado");

        lblEstado.setText("Estado");

        cmdSalir.setText("Salir");
        cmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalirActionPerformed(evt);
            }
        });

        cmdClientes.setText("Ver Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtRutCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                        .addComponent(txtNum)))
                                .addComponent(lblPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmdClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEstado)
                                        .addGap(63, 63, 63)
                                        .addComponent(rbPendiente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmdNuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmdModificarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbListo)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbCancelado))
                                    .addComponent(cmdEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmdSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStockCritico))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomProducto)
                                    .addComponent(txtPrecio)
                                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStock)
                                    .addComponent(txtCodProducto)))
                            .addComponent(lblProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 161, Short.MAX_VALUE)
                                .addComponent(lblBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProducto)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCodProducto)
                                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNomProducto)
                                    .addComponent(txtNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTipo)
                                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPrecio)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblStock)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStockCritico)
                            .addComponent(txtStockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarProducto)
                    .addComponent(cmdNuevoProducto)
                    .addComponent(cmdModificarProducto)
                    .addComponent(cmdEliminarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNum)
                                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRutCliente)
                            .addComponent(txtRutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPendiente)
                            .addComponent(rbListo)
                            .addComponent(rbCancelado)
                            .addComponent(lblEstado)))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdModificarPedido)
                    .addComponent(cmdEliminarPedido)
                    .addComponent(cmdNuevoPedido)
                    .addComponent(lblBuscarPedido)
                    .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdSalir)
                    .addComponent(cmdClientes))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cmdSalirActionPerformed

    private void lstProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstProductoMouseClicked
        String info;
        Boolean continuar = true;
        int c;
        
        cmdModificarProducto.setEnabled(true);
        cmdEliminarProducto.setEnabled(true);
        txtCodProducto.setEnabled(false);
        cmdNuevoProducto.setText("Nuevo");
        cmdNuevoProducto.setToolTipText("Habilitar Insercion");
        
        info = String.valueOf(lstProducto.getSelectedValue());
        txtCodProducto.setText(info.substring(0,info.indexOf("#")).trim());
        txtNomProducto.setText(info.substring(info.indexOf("#") + 1,info.indexOf("/")).trim());
        txtPrecio.setText(info.substring(info.indexOf("$") + 1,info.indexOf("%")).trim());
        txtStock.setText(info.substring(info.indexOf("%") + 1,info.indexOf("!")).trim());
        txtStockCritico.setText(info.substring(info.indexOf("!") + 1,info.length()));
        
        c = 0;
        do{
            if(String.valueOf(cmbTipo.getItemAt(c)).equals(info.substring(info.indexOf("/") + 1,info.indexOf("$")).trim())){
                cmbTipo.setSelectedIndex(c);
                continuar = false;
            }
            c++;
        }while((continuar) && (cmbTipo.getItemCount()>c));
    }//GEN-LAST:event_lstProductoMouseClicked

    private void lstPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPedidoMouseClicked
        String info;
        
        cmdModificarPedido.setEnabled(true);
        cmdEliminarPedido.setEnabled(true);
        txtNum.setEnabled(false);
        cmdNuevoPedido.setText("Nuevo");
        cmdNuevoPedido.setToolTipText("Habilitar Insercion");
        
        info = String.valueOf(lstPedido.getSelectedValue());
        txtNum.setText(info.substring(0,info.indexOf("#")).trim());
        txtRutCliente.setText(info.substring(info.indexOf("#") + 1,info.indexOf("!")).trim());
        
        if(info.substring(info.indexOf("!") + 1,info.length()).trim().equals("Pendiente")){
            rbPendiente.setSelected(rootPaneCheckingEnabled);
        }
        if(info.substring(info.indexOf("!") + 1,info.length()).trim().equals("Listo")){
            rbListo.setSelected(rootPaneCheckingEnabled);
        }
        if(info.substring(info.indexOf("!") + 1,info.length()).trim().equals("Cancelado")){
            rbCancelado.setSelected(rootPaneCheckingEnabled);
        }
        
        con = new Conexion();
        
        String SQL = "SELECT descripcion FROM pedidos WHERE numero="+txtNum.getText();
        try{
            ResultSet des = con.listar(SQL);
            des.next();
            txtDescripcion.setText(des.getString("descripcion"));
        }catch(Exception ex){
            
        }

        con.close();
    }//GEN-LAST:event_lstPedidoMouseClicked

    private void cmdNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoProductoActionPerformed
        if((cmdNuevoProducto.getText()).equals("Insertar")){
            String cod = txtCodProducto.getText();
            String nom = txtNomProducto.getText();
            String tipo = String.valueOf(cmbTipo.getSelectedItem());
            int precio = Integer.parseInt(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            int stockCritico = Integer.parseInt(txtStockCritico.getText());

            con = new Conexion();

            String SQL = "INSERT INTO productos (codigo,nombre,tipo,precio,stock,stockCritico) VALUES ('"+cod+"','"+nom+"','"+tipo+"',"+precio+","+stock+","+stockCritico+")";

            con.query(SQL);
            con.close();

            llenarListaProducto();
        }else{
            txtCodProducto.setEnabled(true);
            cmdModificarProducto.setEnabled(false);
            cmdEliminarProducto.setEnabled(false);
            cmdNuevoProducto.setText("Insertar");
            cmdNuevoProducto.setToolTipText("Insertar en la base de datos");
        }
        
        txtCodProducto.setText(null);
        txtNomProducto.setText(null);
        cmbTipo.setSelectedIndex(0);
        txtPrecio.setText(null);
        txtStock.setText(null);
        txtStockCritico.setText(null);
    }//GEN-LAST:event_cmdNuevoProductoActionPerformed

    private void cmdNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoPedidoActionPerformed
        if((cmdNuevoPedido.getText()).equals("Insertar")){
            String num = txtNum.getText();
            String rut = txtRutCliente.getText();
            String des = txtDescripcion.getText();
            String est;
            if(rbPendiente.isSelected()){
                est="Pendiente";
            }else{
                if(rbListo.isSelected()){
                    est="Listo";
                }else{
                    est="Cancelado";
                }
            }

            con = new Conexion();

            String SQL = "INSERT INTO pedidos (numero,rutCliente,descripcion,estado) VALUES ("+num+",'"+rut+"','"+des+"','"+est+"')";

            con.query(SQL);
            con.close();
            
            llenarListaPedidos();
        }else{
            txtNum.setEnabled(true);
            cmdModificarPedido.setEnabled(false);
            cmdEliminarPedido.setEnabled(false);
            cmdNuevoPedido.setText("Insertar");
            cmdNuevoPedido.setToolTipText("Insertar en la base de datos");
        }
        
        txtNum.setText(null);
        txtRutCliente.setText(null);
        txtDescripcion.setText(null);
        rbPendiente.setSelected(rootPaneCheckingEnabled);  
    }//GEN-LAST:event_cmdNuevoPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgEstado;
    private javax.swing.JComboBox<String> cmbBuscarPedido;
    private javax.swing.JComboBox<String> cmbBuscarProducto;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JButton cmdClientes;
    private javax.swing.JButton cmdEliminarPedido;
    private javax.swing.JButton cmdEliminarProducto;
    private javax.swing.JButton cmdModificarPedido;
    private javax.swing.JButton cmdModificarProducto;
    private javax.swing.JButton cmdNuevoPedido;
    private javax.swing.JButton cmdNuevoProducto;
    private javax.swing.JButton cmdSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBuscarPedido;
    private javax.swing.JLabel lblBuscarProducto;
    private javax.swing.JLabel lblCodProducto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNomProducto;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblRutCliente;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblStockCritico;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JList<String> lstPedido;
    private javax.swing.JList<String> lstProducto;
    private javax.swing.JRadioButton rbCancelado;
    private javax.swing.JRadioButton rbListo;
    private javax.swing.JRadioButton rbPendiente;
    private javax.swing.JTextField txtBuscarPedido;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNomProducto;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRutCliente;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStockCritico;
    // End of variables declaration//GEN-END:variables
}
