/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Controllers.LinhKienController;
import Controllers.LinhKienDaNhapController;
import Models.LinhKien;
import Models.LinhKienNhap;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ddom6
 */
public final class frmLinhKienNhap extends javax.swing.JFrame {

    private String TaiKhoan;
    private String MatKhau;
    private DefaultTableModel defaultTableModelLinhKien;
    private DefaultTableModel defaultTableModelLinhKienDaNhap;

    private LinhKienController linhKienController;
    private LinhKienDaNhapController linhKienDaNhapController;

    /**
     * Creates new form fromQuanlyDoDung
     */
    public frmLinhKienNhap() {
        initComponents();
        InsertDataTable();

    }

    public frmLinhKienNhap(String TK, String MK) {
        initComponents();
        this.TaiKhoan = TK;
        this.MatKhau = MK;
        InsertDataTable();

    }

    public void InsertDataTable() {
        linhKienController = new LinhKienController();
        linhKienDaNhapController = new LinhKienDaNhapController();

        defaultTableModelLinhKien = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        defaultTableModelLinhKienDaNhap = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tbLinhKien.setModel(defaultTableModelLinhKien);
        defaultTableModelLinhKien.addColumn("Mã linh kiện");
        defaultTableModelLinhKien.addColumn("Tên linh kiện");
        defaultTableModelLinhKien.addColumn("Loại");
        defaultTableModelLinhKien.addColumn("Số lượng");
        defaultTableModelLinhKien.addColumn("Giá bán");
        defaultTableModelLinhKien.addColumn("Hãng");
        defaultTableModelLinhKien.addColumn("Hạn bảo hành");

        tbLinhKienDaNhap.setModel(defaultTableModelLinhKienDaNhap);
        defaultTableModelLinhKienDaNhap.addColumn("Mã nhập");
        defaultTableModelLinhKienDaNhap.addColumn("Mã linh kiện");
        defaultTableModelLinhKienDaNhap.addColumn("Số lượng");
        defaultTableModelLinhKienDaNhap.addColumn("Giá nhập");
        defaultTableModelLinhKienDaNhap.addColumn("Tổng tiền");
        defaultTableModelLinhKienDaNhap.addColumn("Ngày nhập");
        defaultTableModelLinhKienDaNhap.addColumn("Nguồn nhập");
        defaultTableModelLinhKienDaNhap.addColumn("Người nhập");

        LoadDataTable();
        txtMaLK.requestFocus();
    }

    public void LoadDataTable() {
        cbMaNhap.removeAllItems();
        cbLoai.removeAllItems();

        List<LinhKien> linhKiens = linhKienController.GetAllLinhKien();
        List<LinhKienNhap> linhKienNhaps = linhKienDaNhapController.GetAllLinhKienDaNhap();

        List<String> listLoai = linhKienController.GetAllLoaiLinhKien();

        for (LinhKien linhKien : linhKiens) {
            defaultTableModelLinhKien.addRow(new Object[]{
                linhKien.getMaLK(),
                linhKien.getTenLK(),
                linhKien.getLoai(),
                linhKien.getSoLuong(),
                linhKien.getGiaBan(),
                linhKien.getHang(),
                linhKien.getHanBaoHanh(),});

        }

        cbLoai.addItem("Chọn");
        for (String loai : listLoai) {
            cbLoai.addItem(loai);
        }

        List<String> listHang = linhKienController.GetAllHang();
        cbHang.addItem("Chọn");

        for (String hang : listHang) {
            cbHang.addItem(hang);
        }

        for (LinhKienNhap linhKienNhap : linhKienNhaps) {
            defaultTableModelLinhKienDaNhap.addRow(new Object[]{
                linhKienNhap.getMaNhap(),
                linhKienNhap.getMaLK(),
                linhKienNhap.getSoLuong(),
                linhKienNhap.getGiaNhap(),
                linhKienNhap.getTongTien(),
                linhKienNhap.getNgayNhap(),
                linhKienNhap.getNguonNhap(),
                linhKienNhap.getNguoiNhap(),});

            cbMaNhap.addItem(linhKienNhap.getMaNhap());
        }
    }

    public void clearDataTable() {
        while (defaultTableModelLinhKien.getRowCount() > 0) {
            defaultTableModelLinhKien.removeRow(0);
        }
        while (defaultTableModelLinhKienDaNhap.getRowCount() > 0) {
            defaultTableModelLinhKienDaNhap.removeRow(0);
        }
    }

    public void ClearTextField() {
        txtMaLK.setText(null);
        txtTenLK.setText(null);
        cbLoai.setSelectedIndex(0);
        cbHang.setSelectedIndex(0);
        txtGiaBan.setText(null);
        txtMaNhap.setText(null);
        spinnerSoLuongLK.setValue(0);
        txtGiaNhap.setText(null);
        txtNgayNhap.setText(null);
        txtNguonNhap.setText(null);
        txtNguoiNhap.setText(null);
        txtHanBaoHanh.setText(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnClearText = new javax.swing.JButton();
        spinnerSoLuongLK = new javax.swing.JSpinner();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaNhap = new javax.swing.JTextField();
        txtNgayNhap = new javax.swing.JTextField();
        dfghrfghj = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNguoiNhap = new javax.swing.JTextField();
        txtNguonNhap = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtHanBaoHanh = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLinhKien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtTenLK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMaLK = new javax.swing.JTextField();
        txt = new javax.swing.JLabel();
        cbHang = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLinhKienDaNhap = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        cbMaNhap = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nhập linh kiện");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin linh kiện nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã nhập");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng");

        btnClearText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClearText.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\eraser.png")); // NOI18N
        btnClearText.setText("Clear");
        btnClearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTextActionPerformed(evt);
            }
        });

        spinnerSoLuongLK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinnerSoLuongLK.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spinnerSoLuongLK.setToolTipText("");

        txtGiaNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Giá nhập");

        txtMaNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNgayNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        dfghrfghj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dfghrfghj.setText("Ngày nhập");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Người nhập");

        txtNguoiNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNguonNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Nguồn nhập");

        txtHanBaoHanh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Hạn bảo hành");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNguonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNguoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaNhap)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(spinnerSoLuongLK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 63, Short.MAX_VALUE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(dfghrfghj)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgayNhap))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnClearText, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(jLabel15)
                        .addGap(21, 21, 21)
                        .addComponent(txtHanBaoHanh)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinnerSoLuongLK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtNguoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtNguonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dfghrfghj)
                        .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtHanBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách linh kiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        tbLinhKien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbLinhKien.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbLinhKien.setCellSelectionEnabled(true);
        tbLinhKien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbLinhKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLinhKienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbLinhKien);
        tbLinhKien.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin linh kiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên linh kiện");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giá bán ra");

        txtGiaBan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbLoai.setEditable(true);
        cbLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Loại");

        txtMaLK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt.setText("Mã linh kiện");

        cbHang.setEditable(true);
        cbHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Hãng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt)
                        .addGap(25, 25, 25)
                        .addComponent(txtMaLK))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(cbHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenLK)
                            .addComponent(cbLoai, 0, 240, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaLK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenLK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách linh kiện đã nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        tbLinhKienDaNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbLinhKienDaNhap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbLinhKienDaNhap.setCellSelectionEnabled(true);
        tbLinhKienDaNhap.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbLinhKienDaNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLinhKienDaNhapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbLinhKienDaNhap);
        tbLinhKienDaNhap.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHẬP LINH KIỆN");

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\arrow.png")); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\add.png")); // NOI18N
        btnThem.setText("Nhập");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\refresh.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\bin.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\làm mới.png")); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\search.png")); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cbMaNhap.setEditable(true);
        cbMaNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbMaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbMaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addContainerGap())
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TrangChu trangChu = new TrangChu(TaiKhoan, MatKhau);
        trangChu.setLocationRelativeTo(null);
        trangChu.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tbLinhKienDaNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLinhKienDaNhapMouseClicked
        // TODO add your handling code here:
        defaultTableModelLinhKienDaNhap = (DefaultTableModel) tbLinhKienDaNhap.getModel();
        int row = tbLinhKienDaNhap.getSelectedRow();

        txtMaNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(row, 0).toString());
        spinnerSoLuongLK.setValue(defaultTableModelLinhKienDaNhap.getValueAt(row, 2));
        txtGiaNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(row, 3).toString());
        txtNgayNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(row, 5).toString());
        txtNguonNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(row, 6).toString());
        txtNguoiNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(row, 7).toString());

        txtMaLK.setText(defaultTableModelLinhKienDaNhap.getValueAt(row, 1).toString());
        defaultTableModelLinhKien.setRowCount(0);
        List<LinhKien> linhKiens = linhKienController.SearchLinhKien_MaLK(txtMaLK.getText());

        for (LinhKien linhKien : linhKiens) {
            defaultTableModelLinhKien.addRow(new Object[]{
                linhKien.getMaLK(),
                linhKien.getTenLK(),
                linhKien.getLoai(),
                linhKien.getSoLuong(),
                linhKien.getGiaBan(),
                linhKien.getHanBaoHanh(),});
        }

        if (!linhKiens.isEmpty()) {
            txtTenLK.setText(defaultTableModelLinhKien.getValueAt(0, 1).toString());
            String type = defaultTableModelLinhKien.getValueAt(0, 2).toString();
            switch (type) {
                case "Ốp lưng":
                    cbLoai.setSelectedItem("Ốp lưng");
                    break;
                case "Kính cường lực":
                    cbLoai.setSelectedItem("Kính cường lực");
                    break;
                case "Pin":
                    cbLoai.setSelectedItem("Pin");
                    break;
                case "Sạc":
                    cbLoai.setSelectedItem("Sạc");
                    break;
                default:
                    cbLoai.getEditor().setItem(type);
                    break;
            }
            txtGiaBan.setText(defaultTableModelLinhKien.getValueAt(0, 4).toString());
            txtHanBaoHanh.setText(defaultTableModelLinhKien.getValueAt(0, 5).toString());

        } else {
            txtTenLK.setText(null);
            cbLoai.setSelectedItem("Chọn");
            txtGiaBan.setText(null);
            List<LinhKien> linhKiens1 = linhKienController.GetAllLinhKien();

            for (LinhKien linhKien : linhKiens1) {
                defaultTableModelLinhKien.addRow(new Object[]{
                    linhKien.getMaLK(),
                    linhKien.getTenLK(),
                    linhKien.getLoai(),
                    linhKien.getSoLuong(),
                    linhKien.getGiaBan(),
                    linhKien.getHanBaoHanh(),});

            }
        }

    }//GEN-LAST:event_tbLinhKienDaNhapMouseClicked

    private void btnClearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTextActionPerformed
        // TODO add your handling code here:
        ClearTextField();

    }//GEN-LAST:event_btnClearTextActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        defaultTableModelLinhKien.setRowCount(0);
        defaultTableModelLinhKienDaNhap.setRowCount(0);
        clearDataTable();
        LoadDataTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {

            if (txtTenLK.getText().equals("") || txtTenLK.getText().equals("") || (Integer) spinnerSoLuongLK.getValue() == 0
                    || txtGiaBan.getText().equals("") || txtMaNhap.getText().equals("") || txtGiaNhap.getText().equals("")
                    || txtNgayNhap.getText().equals("") || txtNguoiNhap.getText().equals("") || cbLoai.getSelectedItem().equals("Chọn")
                    || cbHang.getSelectedItem().equals("Chọn") || txtHanBaoHanh.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                List<LinhKienNhap> linhKienNhaps = linhKienDaNhapController.GetAllLinhKienDaNhap();
                for (LinhKienNhap linhKienNhap : linhKienNhaps) {
                    if (txtMaNhap.getText().equals(linhKienNhap.getMaNhap())) {
                        JOptionPane.showMessageDialog(null, "Mã nhập đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txtMaNhap.requestFocus();
                        return;
                    }
                }
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn nhập linh kiện " + txtTenLK.getText() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {

                    LinhKien linhKien = new LinhKien();

                    linhKien.setMaLK(txtMaLK.getText());
                    linhKien.setTenLK(txtTenLK.getText());
                    linhKien.setLoai(cbLoai.getSelectedItem().toString());
                    linhKien.setSoLuong((Integer) spinnerSoLuongLK.getValue());
                    linhKien.setGiaBan(Float.valueOf(txtGiaBan.getText()));
                    linhKien.setHang(cbHang.getSelectedItem().toString());
                    linhKien.setHanBaoHanh(txtHanBaoHanh.getText());

                    LinhKienNhap linhKienNhap = new LinhKienNhap();

                    linhKienNhap.setMaNhap(txtMaNhap.getText());
                    linhKienNhap.setMaLK(txtMaLK.getText());
                    linhKienNhap.setSoLuong((Integer) spinnerSoLuongLK.getValue());
                    linhKienNhap.setGiaNhap(Float.valueOf(txtGiaNhap.getText()));
                    linhKienNhap.setNgayNhap(txtNgayNhap.getText());
                    linhKienNhap.setNguonNhap(txtNguonNhap.getText());
                    linhKienNhap.setNguoiNhap(txtNguoiNhap.getText());

                    boolean check_1 = linhKienController.ThemLinhKien(linhKien);
                    boolean check_2 = linhKienDaNhapController.NhapLinhKien(linhKienNhap);

                    if (check_1 == true && check_2 == true) {
                        JOptionPane.showMessageDialog(null, "Nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        //                defaultTableModel.setRowCount(0);
                        clearDataTable();
                        LoadDataTable();
                        ClearTextField();
                        txtMaLK.requestFocus();

                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            if (txtMaLK.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn hoặc nhập 1 linh kiện đã nhập cần chỉnh sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                if ((Integer) spinnerSoLuongLK.getValue() == 0 || txtGiaNhap.getText().equals("") || txtNgayNhap.getText().equals("")
                        || txtNguoiNhap.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa linh kiện đã nhập " + txtTenLK.getText() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        LinhKienNhap linhKienNhap = new LinhKienNhap();

                        linhKienNhap.setMaNhap(txtMaNhap.getText());
                        linhKienNhap.setMaLK(txtMaLK.getText());
                        linhKienNhap.setSoLuong((Integer) spinnerSoLuongLK.getValue());
                        linhKienNhap.setGiaNhap(Float.valueOf(txtGiaNhap.getText()));
                        linhKienNhap.setNgayNhap(txtNgayNhap.getText());
                        linhKienNhap.setNguonNhap(txtNguonNhap.getText());
                        linhKienNhap.setNguoiNhap(txtNguoiNhap.getText());

                        boolean check = linhKienDaNhapController.SuaLinhKienDaNhap(linhKienNhap);

                        if (check == true) {
                            JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                defaultTableModel.setRowCount(0);
                            clearDataTable();
                            LoadDataTable();
                            ClearTextField();
                            txtMaLK.requestFocus();
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:

        try {
            if (txtMaNhap.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn hoặc nhập 1 linh kiện đã nhập cần chỉnh xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {

                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa linh kiện đã nhập " + txtTenLK.getText() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {

                    boolean check = linhKienDaNhapController.XoaLinhKienDaNhap(txtMaNhap.getText());
                    if (check == true) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                defaultTableModel.setRowCount(0);
                        clearDataTable();
                        LoadDataTable();
                        txtMaLK.requestFocus();

                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        defaultTableModelLinhKienDaNhap.setRowCount(0);
        List<LinhKienNhap> linhKienNhaps = linhKienDaNhapController.SearchLinhKienDaNhap_MaNhap(cbMaNhap.getSelectedItem().toString());

        for (LinhKienNhap linhKienNhap : linhKienNhaps) {
            defaultTableModelLinhKienDaNhap.addRow(new Object[]{
                linhKienNhap.getMaNhap(),
                linhKienNhap.getMaLK(),
                linhKienNhap.getSoLuong(),
                linhKienNhap.getGiaNhap(),
                linhKienNhap.getTongTien(),
                linhKienNhap.getNgayNhap(),
                linhKienNhap.getNguoiNhap(),});
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbLinhKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLinhKienMouseClicked
        // TODO add your handling code here:
        defaultTableModelLinhKien = (DefaultTableModel) tbLinhKien.getModel();
        int row = tbLinhKien.getSelectedRow();

        txtMaLK.setText(defaultTableModelLinhKien.getValueAt(row, 0).toString());
        spinnerSoLuongLK.setValue(defaultTableModelLinhKien.getValueAt(row, 3));

        defaultTableModelLinhKienDaNhap.setRowCount(0);
        List<LinhKienNhap> linhKienNhaps = linhKienDaNhapController.SearchLinhKienDaNhap_MaLK(txtMaLK.getText());
        for (LinhKienNhap linhKienNhap : linhKienNhaps) {
            defaultTableModelLinhKienDaNhap.addRow(new Object[]{
                linhKienNhap.getMaNhap(),
                linhKienNhap.getMaLK(),
                linhKienNhap.getSoLuong(),
                linhKienNhap.getGiaNhap(),
                linhKienNhap.getTongTien(),
                linhKienNhap.getNgayNhap(),
                linhKienNhap.getNguonNhap(),
                linhKienNhap.getNguoiNhap(),});
        }

        if (!linhKienNhaps.isEmpty()) {
            txtMaNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(0, 0).toString());
            txtGiaNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(0, 3).toString());
            txtNgayNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(0, 5).toString());
            txtNguonNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(0, 6).toString());
            txtNguoiNhap.setText(defaultTableModelLinhKienDaNhap.getValueAt(0, 7).toString());
        } else {
            txtMaNhap.setText(null);
            txtGiaNhap.setText(null);
            txtNgayNhap.setText(null);
            txtNguoiNhap.setText(null);
            spinnerSoLuongLK.setValue(0);
            List<LinhKienNhap> linhKienNhaps1 = linhKienDaNhapController.GetAllLinhKienDaNhap();

            for (LinhKienNhap linhKienNhap : linhKienNhaps1) {
                defaultTableModelLinhKienDaNhap.addRow(new Object[]{
                    linhKienNhap.getMaNhap(),
                    linhKienNhap.getMaLK(),
                    linhKienNhap.getSoLuong(),
                    linhKienNhap.getGiaNhap(),
                    linhKienNhap.getTongTien(),
                    linhKienNhap.getNgayNhap(),
                    linhKienNhap.getNguonNhap(),
                    linhKienNhap.getNguoiNhap(),});

            }
        }

        txtTenLK.setText(defaultTableModelLinhKien.getValueAt(row, 1).toString());
        String type = defaultTableModelLinhKien.getValueAt(row, 2).toString();
        switch (type) {
            case "Main":
                cbLoai.setSelectedItem("Main");
                break;
            case "Pin":
                cbLoai.setSelectedItem("Pin");
                break;
            case "Camera":
                cbLoai.setSelectedItem("Camera");
                break;
            case "Màn hình":
                cbLoai.setSelectedItem("Màn hình");
                break;
            case "Vỏ":
                cbLoai.setSelectedItem("Vỏ");
                break;
            default:
                cbLoai.getEditor().setItem(type);
                break;
        }

        txtGiaBan.setText(defaultTableModelLinhKien.getValueAt(row, 4).toString());
        String hang = defaultTableModelLinhKien.getValueAt(row, 5).toString();
        switch (hang) {
            case "Iphone":
                cbHang.setSelectedItem("Iphone");
                break;
            case "SamSung":
                cbHang.setSelectedItem("SamSung");
                break;
            case "Xiaomi":
                cbHang.setSelectedItem("Xiaomi");
                break;
            case "Oppo":
                cbHang.setSelectedItem("Oppo");
                break;
            case "Sony":
                cbHang.setSelectedItem("Sony");
                break;
            case "LG":
                cbHang.setSelectedItem("LG");
                break;
            case "Google":
                cbHang.setSelectedItem("Google");
                break;
            default:
                cbHang.getEditor().setItem(type);
                break;
        }
        txtHanBaoHanh.setText(defaultTableModelLinhKien.getValueAt(row, 6).toString());

    }//GEN-LAST:event_tbLinhKienMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLinhKienNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLinhKienNhap fQuanlyDoDung = new frmLinhKienNhap();
                fQuanlyDoDung.setLocationRelativeTo(null);
                fQuanlyDoDung.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearText;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbHang;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbMaNhap;
    private javax.swing.JLabel dfghrfghj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spinnerSoLuongLK;
    private javax.swing.JTable tbLinhKien;
    private javax.swing.JTable tbLinhKienDaNhap;
    private javax.swing.JLabel txt;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHanBaoHanh;
    private javax.swing.JTextField txtMaLK;
    private javax.swing.JTextField txtMaNhap;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtNguoiNhap;
    private javax.swing.JTextField txtNguonNhap;
    private javax.swing.JTextField txtTenLK;
    // End of variables declaration//GEN-END:variables
}
