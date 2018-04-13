package diplay;
import java.awt.CardLayout;
import java.sql.SQLException;
import mod.mark;
import mod.user;
import dao.dao;
import dao.mark_dao;
public class dispaly extends javax.swing.JFrame {
user u=null;
mark m=null;
public dispaly() {initComponents();}                       
    private void initComponents() {
        name_err = new javax.swing.JDialog();
        jLabel65 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        signup_succ = new javax.swing.JDialog();
        jLabel61 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        student_ifm = new javax.swing.JDialog();
        jLabel66 = new javax.swing.JLabel();
        jButton35 = new javax.swing.JButton();
        setkey_succ = new javax.swing.JDialog();
        jLabel67 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        teacher_mark = new javax.swing.JDialog();
        jLabel68 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        t_ser_m = new javax.swing.JDialog();
        jLabel80 = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();
        Center = new javax.swing.JLayeredPane();
        center = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Teacher = new javax.swing.JLayeredPane();
        teacher = new javax.swing.JPanel();
        登录名1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        Student = new javax.swing.JLayeredPane();
        student = new javax.swing.JPanel();
        登录名2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        S_menu = new javax.swing.JLayeredPane();
        s_menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        S_ifm = new javax.swing.JLayeredPane();
        s_ifm = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        S_mark = new javax.swing.JLayeredPane();
        s_mark = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        T_mune = new javax.swing.JLayeredPane();
        t_menu = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        T_student_ifm = new javax.swing.JLayeredPane();
        t_student_ifm = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        Setkey = new javax.swing.JLayeredPane();
        setkey = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        Signup = new javax.swing.JLayeredPane();
        signup = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        T_s_ifm = new javax.swing.JLayeredPane();
        t_s_ifm = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        Table = new javax.swing.JLayeredPane();
        table = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        T_mark = new javax.swing.JLayeredPane();
        t_mark = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jButton39 = new javax.swing.JButton();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        name_err.setModal(true);name_err.setBounds(150, 100, 250, 200);
        jLabel65.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel65.setText("用户名或密码错误");
        jButton8.setText("确认");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);}});
        javax.swing.GroupLayout name_errLayout = new javax.swing.GroupLayout(name_err.getContentPane());
        name_err.getContentPane().setLayout(name_errLayout);
        name_errLayout.setHorizontalGroup(
            name_errLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(name_errLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(name_errLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(name_errLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(129, Short.MAX_VALUE)));
        name_errLayout.setVerticalGroup(
            name_errLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(name_errLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(62, 62, 62)));
        signup_succ.setModal(true);signup_succ.setBounds(150, 100, 250, 200);
        jLabel61.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel61.setText("注册成功");
        jButton34.setText("确认");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);}});
        javax.swing.GroupLayout signup_succLayout = new javax.swing.GroupLayout(signup_succ.getContentPane());
        signup_succ.getContentPane().setLayout(signup_succLayout);
        signup_succLayout.setHorizontalGroup(
            signup_succLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signup_succLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(signup_succLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addGroup(signup_succLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton34)))
                .addContainerGap(301, Short.MAX_VALUE)));
        signup_succLayout.setVerticalGroup(
            signup_succLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signup_succLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel61)
                .addGap(33, 33, 33)
                .addComponent(jButton34)
                .addContainerGap(194, Short.MAX_VALUE)) );
        student_ifm.setModal(true);student_ifm.setBounds(150, 100, 250, 200);
        jLabel66.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel66.setText("修改成功");jButton35.setText("确定");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);}});
        javax.swing.GroupLayout student_ifmLayout = new javax.swing.GroupLayout(student_ifm.getContentPane());
        student_ifm.getContentPane().setLayout(student_ifmLayout);
        student_ifmLayout.setHorizontalGroup(
            student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_ifmLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addGroup(student_ifmLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton35)))
                .addContainerGap(300, Short.MAX_VALUE)));
        student_ifmLayout.setVerticalGroup(
            student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_ifmLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel66)
                .addGap(46, 46, 46)
                .addComponent(jButton35)
                .addContainerGap(190, Short.MAX_VALUE)));
        setkey_succ.setModal(true);setkey_succ.setBounds(150, 100, 250, 200);
        jLabel67.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel67.setText("修改成功");jButton36.setText("确认");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);}});
        javax.swing.GroupLayout setkey_succLayout = new javax.swing.GroupLayout(setkey_succ.getContentPane());
        setkey_succ.getContentPane().setLayout(setkey_succLayout);
        setkey_succLayout.setHorizontalGroup(
            setkey_succLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setkey_succLayout.createSequentialGroup()
                .addGroup(setkey_succLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setkey_succLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton36))
                    .addGroup(setkey_succLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel67)))
                .addContainerGap(304, Short.MAX_VALUE)));
        setkey_succLayout.setVerticalGroup(
            setkey_succLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setkey_succLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel67)
                .addGap(33, 33, 33)
                .addComponent(jButton36)
                .addContainerGap(201, Short.MAX_VALUE)) );
        teacher_mark.setModal(true);teacher_mark.setBounds(150, 100, 250, 200);
        jLabel68.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel68.setText("修改成功");jButton37.setText("确认");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);}});
        javax.swing.GroupLayout teacher_markLayout = new javax.swing.GroupLayout(teacher_mark.getContentPane());
        teacher_mark.getContentPane().setLayout(teacher_markLayout);
        teacher_markLayout.setHorizontalGroup(
            teacher_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teacher_markLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(teacher_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton37)
                    .addComponent(jLabel68))
                .addContainerGap(295, Short.MAX_VALUE)));
        teacher_markLayout.setVerticalGroup(
            teacher_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teacher_markLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel68)
                .addGap(27, 27, 27)
                .addComponent(jButton37)
                .addContainerGap(199, Short.MAX_VALUE)));
        t_ser_m.setModal(true);t_ser_m.setBounds(150, 100, 250, 200);
        jLabel80.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel80.setText("修改成功");jButton38.setText("确认");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);}});           
        javax.swing.GroupLayout t_ser_mLayout = new javax.swing.GroupLayout(t_ser_m.getContentPane());
        t_ser_m.getContentPane().setLayout(t_ser_mLayout);
        t_ser_mLayout.setHorizontalGroup(
            t_ser_mLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_ser_mLayout.createSequentialGroup()
                .addGroup(t_ser_mLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(t_ser_mLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel80))
                    .addGroup(t_ser_mLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton38)))
                .addContainerGap(294, Short.MAX_VALUE)));
        t_ser_mLayout.setVerticalGroup(
            t_ser_mLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_ser_mLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel80)
                .addGap(28, 28, 28)
                .addComponent(jButton38)
                .addContainerGap(202, Short.MAX_VALUE)));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        Center.setDoubleBuffered(true);
        Center.setPreferredSize(new java.awt.Dimension(500, 418));
        center.setPreferredSize(new java.awt.Dimension(500, 400));
        jButton1.setText("学生登陆");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);}});
        jButton2.setText("管理员登陆");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt); } });
        jLabel2.setFont(new java.awt.Font("幼圆", 1, 14)); // NOI18N
        jLabel2.setText("欢迎使用学生信息管理系统");
        javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
            centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerLayout.createSequentialGroup()
                .addGroup(centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton1)
                        .addGap(135, 135, 135)
                        .addComponent(jButton2))
                    .addGroup(centerLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE)));
        centerLayout.setVerticalGroup(
            centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131)));
        Center.setLayer(center, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout CenterLayout = new javax.swing.GroupLayout(Center);
        Center.setLayout(CenterLayout);
        CenterLayout.setHorizontalGroup(
            CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(center, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        CenterLayout.setVerticalGroup(
            CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(center, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE));
        Teacher.setPreferredSize(new java.awt.Dimension(500, 418));
        teacher.setVisible(false);
        teacher.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        teacher.setPreferredSize(new java.awt.Dimension(500, 400));
        teacher.setRequestFocusEnabled(false);
        登录名1.setText("登陆："); jLabel3.setText("密码：");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);}});
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);}});
        jButton6.setText("登陆");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);}});
        jButton7.setText("重置");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);}
        });
        jLabel5.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("教职工登陆");
        jButton9.setText("返回");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout teacherLayout = new javax.swing.GroupLayout(teacher);
        teacher.setLayout(teacherLayout);
        teacherLayout.setHorizontalGroup(
            teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teacherLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teacherLayout.createSequentialGroup()
                .addGap(0, 114, Short.MAX_VALUE)
                .addGroup(teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(teacherLayout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addGroup(teacherLayout.createSequentialGroup()
                        .addGroup(teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(登录名1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)))
                .addGap(37, 37, 37))
        );
        teacherLayout.setVerticalGroup(
            teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teacherLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(登录名1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton9))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        Teacher.setLayer(teacher, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout TeacherLayout = new javax.swing.GroupLayout(Teacher);
        Teacher.setLayout(TeacherLayout);
        TeacherLayout.setHorizontalGroup(
            TeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(TeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TeacherLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        TeacherLayout.setVerticalGroup(
            TeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(TeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TeacherLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Student.setPreferredSize(new java.awt.Dimension(500, 418));
        student.setVisible(false);
        student.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        student.setPreferredSize(new java.awt.Dimension(500, 400));
        登录名2.setText("登陆：");
        jLabel6.setText("密码：");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jButton10.setText("登陆");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton10ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jButton11.setText("重置");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jButton12.setFont(new java.awt.Font("宋体", 2, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(51, 51, 255));
        jButton12.setText("修改密码");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jLabel7.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("学生登陆");

        jButton39.setText("刷新");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton39ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jButton13.setText("返回");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton27.setText("注册");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout studentLayout = new javax.swing.GroupLayout(student);
        student.setLayout(studentLayout);
        studentLayout.setHorizontalGroup(
            studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentLayout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addGap(27, 27, 27)
                        .addComponent(jButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentLayout.createSequentialGroup()
                        .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(studentLayout.createSequentialGroup()
                                .addComponent(登录名2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton27))
                            .addGroup(studentLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)))
                        .addGap(77, 77, 77))))
        );
        studentLayout.setVerticalGroup(
            studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(登录名2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27))
                .addGap(31, 31, 31)
                .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12)))
                .addGap(67, 67, 67)
                .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton13))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        Student.setLayer(student, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout StudentLayout = new javax.swing.GroupLayout(Student);
        Student.setLayout(StudentLayout);
        StudentLayout.setHorizontalGroup(
            StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(student, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        StudentLayout.setVerticalGroup(
            StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(student, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
        S_menu.setPreferredSize(new java.awt.Dimension(500, 418));
        s_menu.setVisible(false);
        s_menu.setPreferredSize(new java.awt.Dimension(500, 400));
        jLabel1.setText("你好！");
        jButton3.setText("注销");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("巩光乾同学");
        jButton4.setText("个人信息");
        jButton4.setPreferredSize(new java.awt.Dimension(80, 20));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton4ActionPerformed(evt);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jButton5.setText("成绩查询");
        jButton5.setPreferredSize(new java.awt.Dimension(80, 20));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton14.setText("课表查询");
        jButton14.setPreferredSize(new java.awt.Dimension(80, 20));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout s_menuLayout = new javax.swing.GroupLayout(s_menu);
        s_menu.setLayout(s_menuLayout);
        s_menuLayout.setHorizontalGroup(
            s_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s_menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18))
            .addGroup(s_menuLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(s_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        s_menuLayout.setVerticalGroup(
            s_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(s_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        S_menu.setLayer(s_menu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout S_menuLayout = new javax.swing.GroupLayout(S_menu);
        S_menu.setLayout(S_menuLayout);
        S_menuLayout.setHorizontalGroup(
            S_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(S_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(S_menuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(s_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        S_menuLayout.setVerticalGroup(
            S_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(S_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(S_menuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(s_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        S_ifm.setPreferredSize(new java.awt.Dimension(500, 418));
        s_ifm.setVisible(false);
        jLabel8.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel8.setText("姓名：");
        jLabel9.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel9.setText("学号：");
        jLabel10.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel10.setText("专业班级：");
        jLabel11.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel11.setText("学院：");
        jLabel12.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel12.setText("性别：");
        jLabel13.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel13.setText("手机/电话：");
        jLabel14.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel14.setText("邮箱：");
        jButton15.setText("修改信息");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton15ActionPerformed(evt);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jButton16.setText("返回");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton16ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jLabel15.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel15.setText("巩光乾");
        jLabel16.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel16.setText("1408080215");
        jLabel17.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel17.setText("惠普开发142");
        jLabel18.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel18.setText("信息科学技术学院");
        jLabel19.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel19.setText("男");
        jTextField1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jTextField1.setText("12345678912");
        jTextField2.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jTextField2.setText("942490944@qq.com");
        jLabel20.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel20.setText("个人信息");
        javax.swing.GroupLayout s_ifmLayout = new javax.swing.GroupLayout(s_ifm);
        s_ifm.setLayout(s_ifmLayout);
        s_ifmLayout.setHorizontalGroup(
            s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s_ifmLayout.createSequentialGroup()
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(s_ifmLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel20))
                    .addGroup(s_ifmLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButton15)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, s_ifmLayout.createSequentialGroup()
                .addGap(0, 97, Short.MAX_VALUE)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(s_ifmLayout.createSequentialGroup()
                        .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16)))
                    .addGroup(s_ifmLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(s_ifmLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(56, 56, 56)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
        );
        s_ifmLayout.setVerticalGroup(
            s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s_ifmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(27, 27, 27)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        S_ifm.setLayer(s_ifm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout S_ifmLayout = new javax.swing.GroupLayout(S_ifm);
        S_ifm.setLayout(S_ifmLayout);
        S_ifmLayout.setHorizontalGroup(
            S_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_ifmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(s_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        S_ifmLayout.setVerticalGroup(
            S_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_ifmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(s_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        s_mark.setVisible(false);
        s_mark.setPreferredSize(new java.awt.Dimension(500, 400));
        jLabel21.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel21.setText("学生成绩");
        jLabel22.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel22.setText("高等数学：");
        jLabel23.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel23.setText("大学英语：");
        jLabel24.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel24.setText("大学物理：");
        jLabel25.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel25.setText("线性代数：");
        jLabel26.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel26.setText("C语言程序设计：");
        jLabel27.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel27.setText("C++程序设计：");
        jLabel28.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel28.setText("JAVA：");
        jButton17.setText("返回");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jLabel29.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel29.setText("###");
        jLabel30.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel30.setText("###");
        jLabel31.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel31.setText("###");
        jLabel32.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel32.setText("###");
        jLabel33.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel33.setText("###");
        jLabel34.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel34.setText("###");
        jLabel35.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel35.setText("###");
        jLabel36.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("课程");
        jLabel37.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel37.setText("成绩");
        javax.swing.GroupLayout s_markLayout = new javax.swing.GroupLayout(s_mark);
        s_mark.setLayout(s_markLayout);
        s_markLayout.setHorizontalGroup(
            s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s_markLayout.createSequentialGroup()
                .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(s_markLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel21))
                    .addGroup(s_markLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, s_markLayout.createSequentialGroup()
                                .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel23)
                                    .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(s_markLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        	.addComponent(jButton39)
                                        	.addComponent(jLabel32)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel35)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel33)))
                                    .addGroup(s_markLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel37)))))))
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, s_markLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton17)
                .addGap(40, 40, 40))
        );
        s_markLayout.setVerticalGroup(
            s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s_markLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGap(25, 25, 25)
                .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(s_markLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32))
                    .addGroup(s_markLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(s_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton39))
                .addComponent(jButton17)
                .addContainerGap())
        );
        S_mark.setLayer(s_mark, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout S_markLayout = new javax.swing.GroupLayout(S_mark);
        S_mark.setLayout(S_markLayout);
        S_markLayout.setHorizontalGroup(
            S_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(s_mark, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
        S_markLayout.setVerticalGroup(
            S_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(s_mark, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        T_mune.setPreferredSize(new java.awt.Dimension(500, 418));
        t_menu.setVisible(false);
        t_menu.setPreferredSize(new java.awt.Dimension(500, 400));
        jLabel38.setText("你好！");
        jLabel39.setText("巩光乾老师");
        jButton18.setText("注销");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("学生成绩管理");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jButton20.setText("学生信息查询");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout t_menuLayout = new javax.swing.GroupLayout(t_menu);
        t_menu.setLayout(t_menuLayout);
        t_menuLayout.setHorizontalGroup(
            t_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_menuLayout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addGap(14, 14, 14)
                .addComponent(jButton18)
                .addContainerGap())
            .addGroup(t_menuLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(t_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton20)
                    .addComponent(jButton19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        t_menuLayout.setVerticalGroup(
            t_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(t_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38))
                .addGap(125, 125, 125)
                .addComponent(jButton19)
                .addGap(18, 18, 18)
                .addComponent(jButton20)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        T_mune.setLayer(t_menu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout T_muneLayout = new javax.swing.GroupLayout(T_mune);
        T_mune.setLayout(T_muneLayout);
        T_muneLayout.setHorizontalGroup(
            T_muneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(T_muneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(T_muneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(t_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        T_muneLayout.setVerticalGroup(
            T_muneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(T_muneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(T_muneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(t_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        T_student_ifm.setPreferredSize(new java.awt.Dimension(500, 418));
        t_student_ifm.setVisible(false);
        t_student_ifm.setPreferredSize(new java.awt.Dimension(500, 400));
        jLabel41.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel41.setText("学生信息管理");
        jLabel42.setText("");
        jLabel43.setText("学号：");
        jTextField7.setText("jTextField7");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jLabel44.setText("姓名：");
        jButton22.setText("按学号查询");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton22ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jTextField8.setText("jTextField8");
        jButton23.setText("按姓名查询");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton23ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jLabel45.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel45.setText("");
        jLabel46.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel46.setText("");
        jButton24.setText("返回");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout t_student_ifmLayout = new javax.swing.GroupLayout(t_student_ifm);
        t_student_ifm.setLayout(t_student_ifmLayout);
        t_student_ifmLayout.setHorizontalGroup(
            t_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_student_ifmLayout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton22)
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton23)
                .addContainerGap())
            .addGroup(t_student_ifmLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(t_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(t_student_ifmLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(t_student_ifmLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel46)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel45)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, t_student_ifmLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(t_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, t_student_ifmLayout.createSequentialGroup()
                        .addComponent(jButton24)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, t_student_ifmLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(196, 196, 196))))
        );
        t_student_ifmLayout.setVerticalGroup(
            t_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_student_ifmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addGap(45, 45, 45)
                .addGroup(t_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(t_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel42)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(t_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jButton22)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton24)
                .addGap(28, 28, 28))
        );
        T_student_ifm.setLayer(t_student_ifm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout T_student_ifmLayout = new javax.swing.GroupLayout(T_student_ifm);
        T_student_ifm.setLayout(T_student_ifmLayout);
        T_student_ifmLayout.setHorizontalGroup(
            T_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(t_student_ifm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        T_student_ifmLayout.setVerticalGroup(
            T_student_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(t_student_ifm, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
        Setkey.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Setkey.setPreferredSize(new java.awt.Dimension(500, 418));
        setkey.setVisible(false);
        jLabel47.setText("学号：");
        jLabel48.setText("新密码：");
        jLabel49.setText("以前密码：");
        jLabel50.setText("确定密码：");
        jTextField9.setText("1408080215");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField10.setText("******");
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField11.setText("******");
        jTextField12.setText("******");
        jLabel51.setText("（六位数字）");
        jButton25.setText("确认修改");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton25ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jButton26.setText("取消");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jLabel52.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel52.setText("修改密码");
        javax.swing.GroupLayout setkeyLayout = new javax.swing.GroupLayout(setkey);
        setkey.setLayout(setkeyLayout);
        setkeyLayout.setHorizontalGroup(
            setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setkeyLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton25)
                    .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(setkeyLayout.createSequentialGroup()
                            .addComponent(jLabel50)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField12))
                        .addGroup(setkeyLayout.createSequentialGroup()
                            .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel49)
                                .addComponent(jLabel48)
                                .addComponent(jLabel47))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51)
                    .addComponent(jButton26))
                .addGap(55, 55, 55))
            .addGroup(setkeyLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel52)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setkeyLayout.setVerticalGroup(
            setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setkeyLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel52)
                .addGap(60, 60, 60)
                .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addGap(19, 19, 19)
                .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(setkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25)
                    .addComponent(jButton26))
                .addGap(53, 53, 53))
        );
        Setkey.setLayer(setkey, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout SetkeyLayout = new javax.swing.GroupLayout(Setkey);
        Setkey.setLayout(SetkeyLayout);
        SetkeyLayout.setHorizontalGroup(
            SetkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(SetkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SetkeyLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(setkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        SetkeyLayout.setVerticalGroup(
            SetkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(SetkeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SetkeyLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(setkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Signup.setEnabled(false);
        signup.setVisible(false);
        jLabel60.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel60.setText("信息注册");
        jLabel71.setText("手机/电话：");
        jLabel72.setText("专业班级：");
        jButton29.setText("返回");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setText("确定");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton30ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jLabel73.setText("姓名：");
        jLabel74.setText("学院：");
        jLabel75.setText("密码：");
        jLabel76.setText("性别：");
        jLabel77.setText("学号：");
        jLabel69.setText("邮箱：");
        jTextField20.setText("jTextField20");
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        jTextField21.setText("jTextField21");
        jTextField22.setText("jTextField22");
        jTextField23.setText("jTextField23");
        jTextField24.setText("jTextField24");
        jTextField25.setText("jTextField25");
        jTextField26.setText("jTextField26");
        jTextField27.setText("jTextField27");
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout signupLayout = new javax.swing.GroupLayout(signup);
        signup.setLayout(signupLayout);
        signupLayout.setHorizontalGroup(
            signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel60))
                    .addGroup(signupLayout.createSequentialGroup()
                        .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76)
                            .addComponent(jLabel77)
                            .addComponent(jLabel69)
                            .addComponent(jLabel71)
                            .addComponent(jLabel72))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(signupLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signupLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton30)
                        .addGap(63, 63, 63)
                        .addComponent(jButton29)))
                .addGap(24, 24, 24))
        );
        signupLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel69, jLabel71, jLabel72, jLabel73, jLabel74, jLabel75, jLabel76, jLabel77});
        signupLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField20, jTextField21, jTextField22, jTextField23, jTextField24, jTextField25, jTextField26, jTextField27});
        signupLayout.setVerticalGroup(
            signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton30)
                    .addComponent(jButton29))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        signupLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel69, jLabel71, jLabel72, jLabel73, jLabel74, jLabel75, jLabel76, jLabel77});
        signupLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField20, jTextField21, jTextField22, jTextField23, jTextField24, jTextField25, jTextField26, jTextField27});
        Signup.setLayer(signup, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout SignupLayout = new javax.swing.GroupLayout(Signup);
        Signup.setLayout(SignupLayout);
        SignupLayout.setHorizontalGroup(
            SignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
            .addGroup(SignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SignupLayout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        SignupLayout.setVerticalGroup(
            SignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
            .addGroup(SignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SignupLayout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        T_s_ifm.setPreferredSize(new java.awt.Dimension(500, 418));
        t_s_ifm.setVisible(false);
        t_s_ifm.setPreferredSize(new java.awt.Dimension(500, 400));
        jLabel40.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel40.setText("修改学生信息");
        jTextField28.setText("jTextField27");
        jTextField29.setText("jTextField25");
        jTextField30.setText("jTextField26");
        jTextField31.setText("jTextField23");
        jTextField32.setText("jTextField24");
        jTextField33.setText("jTextField21");
        jTextField35.setText("jTextField20");
        jLabel70.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel70.setText("邮箱：");
        jLabel78.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel78.setText("学号：");
        jLabel79.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel79.setText("性别：");
        jLabel81.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel81.setText("学院：");
        jLabel82.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel82.setText("姓名：");
        jLabel83.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel83.setText("手机/电话：");
        jButton31.setText("确定");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton31ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jButton32.setText("返回");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jLabel84.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel84.setText("专业班级：");
        javax.swing.GroupLayout t_s_ifmLayout = new javax.swing.GroupLayout(t_s_ifm);
        t_s_ifm.setLayout(t_s_ifmLayout);
        t_s_ifmLayout.setHorizontalGroup(
            t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_s_ifmLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(t_s_ifmLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, t_s_ifmLayout.createSequentialGroup()
                        .addComponent(jButton31)
                        .addGap(56, 56, 56)
                        .addComponent(jButton32)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(t_s_ifmLayout.createSequentialGroup()
                            .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel79)
                                .addComponent(jLabel81)
                                .addComponent(jLabel84)
                                .addComponent(jLabel83)
                                .addComponent(jLabel70)
                                .addComponent(jLabel78))
                            .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(t_s_ifmLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, t_s_ifmLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(t_s_ifmLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField32)
                                        .addComponent(jTextField29)
                                        .addComponent(jTextField30)
                                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(jLabel82)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        t_s_ifmLayout.setVerticalGroup(
            t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_s_ifmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82))
                .addGap(15, 15, 15)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addGap(15, 15, 15)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(t_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton32)
                    .addComponent(jButton31))
                .addGap(37, 37, 37))
        );
        T_s_ifm.setLayer(t_s_ifm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        javax.swing.GroupLayout T_s_ifmLayout = new javax.swing.GroupLayout(T_s_ifm);
        T_s_ifm.setLayout(T_s_ifmLayout);
        T_s_ifmLayout.setHorizontalGroup(
            T_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_s_ifmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(t_s_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        T_s_ifmLayout.setVerticalGroup(
            T_s_ifmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_s_ifmLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(t_s_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Table.setPreferredSize(new java.awt.Dimension(501, 418));
        table.setVisible(false);
        table.setPreferredSize(new java.awt.Dimension(500, 400));
        jLabel53.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel53.setText("课程表");
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "高等数学", "大学英语", "C语言", "C++", "大学物理", null, null},
                {"2", "JAVA", "大学物理", "大学物理", "大学英语", "C语言", null, null},
                {"3", null, null, "线性代数", null, null, null, null},
                {"4", null, null, "高等数学", null, null, null, null}
            },
            new String [] {
                "", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"
            }
        ));
        jTable1.setMinimumSize(new java.awt.Dimension(120, 40));
        jTable1.setPreferredSize(new java.awt.Dimension(300, 148));
        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        jButton21.setText("返回");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tableLayout = new javax.swing.GroupLayout(table);
        table.setLayout(tableLayout);
        tableLayout.setHorizontalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel53)
                .addContainerGap(233, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton21)
                .addGap(34, 34, 34))
            .addGroup(tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        tableLayout.setVerticalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Table.setLayer(table, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout TableLayout = new javax.swing.GroupLayout(Table);
        Table.setLayout(TableLayout);
        TableLayout.setHorizontalGroup(
            TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
            .addGroup(TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TableLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        TableLayout.setVerticalGroup(
            TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TableLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        T_mark.setPreferredSize(new java.awt.Dimension(500, 418));

        t_mark.setVisible(false);
        t_mark.setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel54.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel54.setText("学生成绩管理");

        jLabel55.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel55.setText("学生学号：");

     
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel56.setText("高等数学：");

        jLabel57.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel57.setText("大学英语：");

        jLabel58.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel58.setText("线性代数：");

        jLabel59.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel59.setText("C语言程序设计：");

        jLabel62.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel62.setText("C++程序设计：");

        jLabel63.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel63.setText("大学物理：");

        jLabel64.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel64.setText("JAVA：");

       

        jButton28.setText("修改");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton28ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jButton33.setText("返回");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout t_markLayout = new javax.swing.GroupLayout(t_mark);
        t_mark.setLayout(t_markLayout);
        t_markLayout.setHorizontalGroup(
            t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_markLayout.createSequentialGroup()
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(t_markLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel54))
                    .addGroup(t_markLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(jLabel63)
                            .addComponent(jLabel64)
                            .addComponent(jLabel62)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59))
                        .addGap(49, 49, 49)
                        .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField16,javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18,javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(t_markLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton28)
                        .addGap(52, 52, 52)
                        .addComponent(jButton33)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        t_markLayout.setVerticalGroup(
            t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t_markLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(t_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton28)
                    .addComponent(jButton33))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        T_mark.setLayer(t_mark, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout T_markLayout = new javax.swing.GroupLayout(T_mark);
        T_mark.setLayout(T_markLayout);
        T_markLayout.setHorizontalGroup(
            T_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_markLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(t_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        T_markLayout.setVerticalGroup(
            T_markLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, T_markLayout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(t_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(S_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(S_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(S_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(T_mune, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(T_student_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Setkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(T_s_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(T_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(S_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 41, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(S_ifm, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 40, Short.MAX_VALUE)
                    .addComponent(S_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 40, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(T_mune, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 41, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(T_student_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 41, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Setkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(93, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(T_s_ifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 41, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(Table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 41, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(T_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 41, Short.MAX_VALUE)))
        );

     setSize(580, 500);
     jTextField13.setSize(60,20);
     jLabel29.setText("");
     jLabel30.setText("");
     jLabel31.setText("");
     jLabel32.setText("");
     jLabel33.setText("");
     jLabel34.setText("");
     jLabel35.setText("");
     jTextField9.setText("");
     jTextField10.setText("");
     jTextField11.setText("");
     jTextField12.setText("");
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
           center.setVisible(false); teacher.setVisible(true);
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       center.setVisible(false); student.setVisible(true);
    }                                        

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	int pass;
    	String id;
    	id=jTextField3.getText();
    	pass=Integer.valueOf(jTextField4.getText());
    	System.out.println(pass);
    	if(id.equals("root")&&pass==123)
    	{
    		jLabel39.setText("管理员");
    		teacher.setVisible(false);t_menu.setVisible(true);
    		}
    	else
    	{
    		jLabel65.setText("用户名或者密码错误");
    		name_err.setVisible(true);
    	}
    	
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jTextField3.setText("");
        jTextField4.setText("");
    }                                        

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        teacher.setVisible(false);center.setVisible(true);
    }                                        

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                          
    	int id,pass;
    	id=Integer.valueOf(jTextField5.getText());
    	pass=Integer.valueOf(jTextField6.getText());
    	System.out.println("1");
    	dao d=new dao();
    	u=d.search(id);
        
    	System.out.println(u.toString());
    	if(u.getPassword()==pass)
    	{
    		jLabel16.setText(Integer.toString(u.getId()));
    		jLabel4.setText(u.getName());
    		jTextField5.setText("");
    		jTextField6.setText("");
    		student.setVisible(false);
    		s_menu.setVisible(true);
    		}
    	else
    	{
    		jLabel65.setText("用户名或者密码错误");
    		name_err.setVisible(true);
    	}
    }                                         

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      jTextField5.setText("");
      jTextField6.setText("");
      
    }                                         

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      student.setVisible(false);center.setVisible(true);
    }                                         

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         s_menu.setVisible(false);center.setVisible(true);
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws NumberFormatException, SQLException {                                         
    	 dao d=new dao();
         u=d.search(Integer.valueOf(jLabel16.getText()));
         jLabel15.setText(u.getName());
         jLabel17.setText(u.getSchool());
         jLabel18.setText(u.getClasses());
         jLabel19.setText(u.getSex());
         jTextField1.setText(Integer.toString(u.getPhone()));
         jTextField2.setText(u.getEmail());
    	s_menu.setVisible(false);s_ifm.setVisible(true);
    }                                        

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       s_menu.setVisible(false);table.setVisible(true);
    }                                         

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) throws NumberFormatException, SQLException {                                          
      
    	 dao d=new dao();
         u=d.search(Integer.valueOf(jLabel16.getText()));
         u.setPhone(Integer.valueOf(jTextField1.getText()));
         u.setEmail(jTextField2.getText());
         System.out.print(u.toString());
         d.updata(u);
    }                                         

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        t_menu.setVisible(false);center.setVisible(true);
    }                                         

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       t_menu.setVisible(false);t_mark.setVisible(true);
    }                                         

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) { 
    	jTextField7.setText("");
    	jTextField8.setText("");
       t_menu.setVisible(false);t_student_ifm.setVisible(true);
    }                                         

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       t_student_ifm.setVisible(false);t_menu.setVisible(true);
    }                                         

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       s_menu.setVisible(false);s_mark.setVisible(true);
    }                                        

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                          
    
    	s_ifm.setVisible(false);s_menu.setVisible(true);
    }                                         

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      s_mark.setVisible(false);s_menu.setVisible(true);
    }                                         

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                 
    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                          
       int id=Integer.valueOf(jLabel16.getText());
       mark_dao md=new mark_dao();
       m=md.search(id);
       jLabel29.setText(Integer.toString(m.getEnglish()));
       jLabel30.setText(Integer.toString(m.getLanguage_c()));
       jLabel31.setText(Integer.toString(m.getLanguage_ch()));
       jLabel32.setText(Integer.toString(m.getJava()));
       jLabel33.setText(Integer.toString(m.getPhysic()));
       jLabel34.setText(Integer.toString(m.getMath()));
       jLabel35.setText(Integer.toString(m.getLinemath()));
       System.out.println(jLabel6.getText());
    }     

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                          
    	dao d=new dao();
		int a,b;
		a=Integer.valueOf(jTextField9.getText());
		b=Integer.valueOf(jTextField10.getText());
		u=d.search(a);
		if(u.getPassword()==b)
		{
			if(Integer.valueOf(jTextField11.getText())!=Integer.valueOf(jTextField12.getText()))
				{
				jLabel65.setText("两次输入的新密码不一致");
				name_err.setVisible(true);
				}
			else 
			{
				u.setPassword(Integer.valueOf(jTextField11.getText()));
				d.updata(u);
				jLabel67.setText("密码修改成功");
				setkey_succ.setVisible(true);
			}
		}
		else 
		{
			jLabel65.setText("密码错误");
			name_err.setVisible(true);
		
			}
    }                                         

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        setkey.setVisible(false);student.setVisible(true);
    }                                         

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       signup.setVisible(false);student.setVisible(true);
    }                                         

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                          
    	dao d=new dao();
    	u =new user();
    	u.setName(jTextField20.getText());
        u.setId(Integer.valueOf(jTextField21.getText()));
        u.setPassword(Integer.valueOf(jTextField22.getText()));
        u.setSex(jTextField23.getText());
        u.setSchool(jTextField24.getText());
        u.setClasses(jTextField25.getText());
        u.setPhone(Integer.valueOf(jTextField26.getText()));
        u.setEmail(jTextField27.getText());
        d.add(u);
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
        jTextField26.setText("");
        jTextField27.setText("");
        signup_succ.setVisible(true);
    }                                         

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {   
    	int id=Integer.valueOf(jTextField7.getText());
    	dao d=new dao();
    	u=d.search(id);
    	jTextField28.setText(u.getEmail());
    	jTextField29.setText(u.getClasses());
    	jTextField30.setText(Integer.toString(u.getPhone()));
    	jTextField31.setText(Integer.toString(u.getId()));
    	jTextField32.setText(u.getSchool());
    	jTextField33.setText(u.getSex());
    	jTextField35.setText(u.getName());
      t_student_ifm.setVisible(false); t_s_ifm.setVisible(true);
    }                                         

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException { 
    	String name=jTextField8.getText();
    	dao d=new dao();
    	u=d.search(name);
    	jTextField28.setText(u.getEmail());
    	jTextField29.setText(u.getClasses());
    	jTextField30.setText(Integer.toString(u.getPhone()));
    	jTextField31.setText(Integer.toString(u.getId()));
    	jTextField32.setText(u.getSchool());
    	jTextField33.setText(u.getSex());
    	jTextField35.setText(u.getName());
        t_student_ifm.setVisible(false); t_s_ifm.setVisible(true);
    }                                         

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                          
        u=new user();
        u.setName(jTextField35.getText());
        u.setSex(jTextField33.getText());
        u.setId(Integer.valueOf(jTextField31.getText()));
        u.setSchool(jTextField32.getText());
        u.setClasses(jTextField29.getText());
        u.setPhone(Integer.valueOf(jTextField30.getText()));
        u.setEmail(jTextField28.getText());
        dao d=new dao();
        d.updata(u);
        t_ser_m.setVisible(true);
    }                                         

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      t_s_ifm.setVisible(false);t_student_ifm.setVisible(true);
    }                                         

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {                                          
     student.setVisible(false);setkey.setVisible(true);
    }                                         

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       table.setVisible(false);s_menu.setVisible(true);
    }                                         

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
    	m=new mark();
        m.setId(Integer.valueOf(jTextField13.getText()));
        m.setMath(Integer.valueOf(jTextField14.getText()));
        m.setEnglish(Integer.valueOf(jTextField15.getText()));
        m.setPhysic(Integer.valueOf(jTextField16.getText()));
        m.setLinemath(Integer.valueOf(jTextField17.getText()));
        m.setLanguage_c(Integer.valueOf(jTextField18.getText()));
        m.setLanguage_ch(Integer.valueOf(jTextField19.getText()));
        m.setJava(Integer.valueOf(jTextField34.getText()));
        dao dao=new dao();
        mark_dao md=new mark_dao();
        u=dao.search(m.getId());
        m.setName(u.getName());
        md.add(m);
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField34.setText("");
        teacher_mark.setVisible(true);
    }                                         

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      t_mark.setVisible(false);t_menu.setVisible(true);
    }                                         

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {   
    	jTextField20.setText("");
    	jTextField21.setText("");
    	jTextField22.setText("");
    	jTextField23.setText("");
    	jTextField24.setText("");
    	jTextField25.setText("");
    	jTextField26.setText("");
    	jTextField27.setText("");
       student.setVisible(false);signup.setVisible(true);
    }                                         

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      name_err.setVisible(false);
    }                                        

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      s_ifm.setVisible(false);
      s_menu.setVisible(true);
      student_ifm.setVisible(false);
    }                                         

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      
        signup_succ.setVisible(false);signup.setVisible(false);
      student.setVisible(true);
      
    }                                         

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        setkey_succ.setVisible(false);
        setkey.setVisible(false);
        student.setVisible(true);
    }                                         

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        teacher_mark.setVisible(false);
        t_mark.setVisible(false);t_menu.setVisible(true);
    }                                         

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {                                          
     t_ser_m.setVisible(false); t_s_ifm.setVisible(false);t_student_ifm.setVisible(true);
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
            java.util.logging.Logger.getLogger(dispaly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dispaly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dispaly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dispaly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dispaly().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLayeredPane Center;
    private javax.swing.JLayeredPane S_ifm;
    private javax.swing.JLayeredPane S_mark;
    private javax.swing.JLayeredPane S_menu;
    private javax.swing.JLayeredPane Setkey;
    private javax.swing.JLayeredPane Signup;
    private javax.swing.JLayeredPane Student;
    private javax.swing.JLayeredPane T_mark;
    private javax.swing.JLayeredPane T_mune;
    private javax.swing.JLayeredPane T_s_ifm;
    private javax.swing.JLayeredPane T_student_ifm;
    private javax.swing.JLayeredPane Table;
    private javax.swing.JLayeredPane Teacher;
    private javax.swing.JPanel center;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jButton39;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
  //  private javax.swing.JTextArea jTextArea2;
  //  private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JDialog name_err;
    private javax.swing.JPanel s_ifm;
    private javax.swing.JPanel s_mark;
    private javax.swing.JPanel s_menu;
    private javax.swing.JPanel setkey;
    private javax.swing.JDialog setkey_succ;
    private javax.swing.JPanel signup;
    private javax.swing.JDialog signup_succ;
    private javax.swing.JPanel student;
    private javax.swing.JDialog student_ifm;
    private javax.swing.JPanel t_mark;
    private javax.swing.JPanel t_menu;
    private javax.swing.JPanel t_s_ifm;
    private javax.swing.JDialog t_ser_m;
    private javax.swing.JPanel t_student_ifm;
    private javax.swing.JPanel table;
    private javax.swing.JPanel teacher;
    private javax.swing.JDialog teacher_mark;
    private javax.swing.JLabel 登录名1;
    private javax.swing.JLabel 登录名2;
    // End of variables declaration                   
}
