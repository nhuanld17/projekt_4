package GUI;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.KhachHang;

public class BillGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private KhachHang khachHang = new KhachHang();
	
	

	public BillGUI(KhachHang khachHang) throws HeadlessException {
		this.khachHang = khachHang;
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BillGUI frame = new BillGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BillGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel.setBounds(154, 0, 144, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 49, 116, 25);
		panel.add(lblNewLabel_1);
		
		JLabel label_ID = new JLabel(String.valueOf(khachHang.getId()));
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_ID.setBounds(285, 52, 82, 18);
		panel.add(label_ID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(39, 85, 116, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel label_Name = new JLabel(khachHang.getName());
		label_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Name.setBounds(285, 88, 82, 18);
		panel.add(label_Name);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tuổi:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(39, 121, 116, 25);
		panel.add(lblNewLabel_1_2);
		
		JLabel label_Age = new JLabel(String.valueOf(khachHang.getAge()));
		label_Age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Age.setBounds(285, 124, 82, 18);
		panel.add(label_Age);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày đặt:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(39, 157, 116, 25);
		panel.add(lblNewLabel_1_3);
		
		JLabel Label_DateOrder = new JLabel(khachHang.getDateOrder()+"");
		Label_DateOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_DateOrder.setBounds(285, 160, 82, 18);
		panel.add(Label_DateOrder);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Ngày trả phòng:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(39, 193, 116, 25);
		panel.add(lblNewLabel_1_3_1);
		
		// lấy ngày hiện tại
		LocalDate currentDate = LocalDate.now();
		
		// Định dạng ngày theo yyyy/mm/dd
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = currentDate.format(formatter);
		
		JLabel Label_DateOrder_1 = new JLabel(formattedDate);
		Label_DateOrder_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_DateOrder_1.setBounds(285, 196, 82, 18);
		panel.add(Label_DateOrder_1);
		
		// Tính khoảng cách giữa ngày đặt phòng và trả phòng
		// Ngày từ bảng khách hàng
		Date sqlDate = khachHang.getDateOrder();
		
		// Chuyển đổi từ SQL Date thành LocalDate 
		LocalDate localDateFromSql = sqlDate.toLocalDate();
		
		//Lấy ngày hiện tại currentDate
		
		// Tính khoảng cách
		long daysDifference = ChronoUnit.DAYS.between(localDateFromSql, currentDate);
		
		// Tính tiền 400k 1 ngày
		long money = daysDifference * 400000;
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Thành tiền:");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_2.setBounds(39, 229, 116, 25);
		panel.add(lblNewLabel_1_3_2);
		
		
		
		JLabel label_ThanhTien = new JLabel(money+" VNĐ");
		label_ThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_ThanhTien.setBounds(285, 232, 82, 18);
		panel.add(label_ThanhTien);
		
		JButton btnNewButton = new JButton("Thoát và xóa KH\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(141, 259, 144, 23);
		panel.add(btnNewButton);
		
		setVisible(true);
	}

}
