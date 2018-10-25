package topica.edu.vn.model;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import topica.edu.vn.ui.Dictionary;
import topica.edu.vn.ui.DictionaryManagement;
import topica.edu.vn.ui.Word;

public class DictionaryApplication extends JFrame {
	Scanner sc= new Scanner(System.in);
	Vector<Word> vec= new Vector<Word>();
	ArrayList<Word>dsWord;
	ArrayList<Dictionary>dsDictionary;
	JList<Word> listWord;
	JTextField txtWord_taget,txtWord_explain;
	JButton btnThem,btnXoa,btnThoat, btnSearch;
	ArrayList<Word> myListWord;
	Word wordSelected;
	public DictionaryApplication(String tittle)
	{
		super(tittle);
		addControls();
		addEvents();
	}
	public void addControls()
	{
		Container con= getContentPane();
		JPanel pnMain= new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnDictionary= new JPanel();
		pnDictionary.setLayout(new FlowLayout());
		pnMain.add(pnDictionary);
		JLabel lblDictionary= new JLabel("DICTIONARY");
		lblDictionary.setIcon(new ImageIcon("image/Dictionary.png"));
		lblDictionary.setForeground(Color.BLACK);
		lblDictionary.setHorizontalAlignment(SwingConstants.CENTER);
		lblDictionary.setFont(new Font("Arial", Font.BOLD, 30));
		lblDictionary.setForeground(Color.RED);
		pnDictionary.add(lblDictionary);
				
		
		JPanel pnDanhSachVaChiTiet= new JPanel();
		pnDanhSachVaChiTiet.setLayout(new GridLayout(1, 2));
		pnMain.add(pnDanhSachVaChiTiet);
		
		JPanel pnList= new JPanel();
		pnList.setLayout(new BorderLayout());
		JLabel lblList= new JLabel("Danh Sach Tu dien");
		listWord= new JList<Word>();
		Border borderDanhSach=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderDanhSach= new TitledBorder(borderDanhSach, "Danh Sách Từ Điển");
		titleBorderDanhSach.setTitleJustification(TitledBorder.CENTER);
		titleBorderDanhSach.setTitleColor(Color.RED);
		pnList.setBorder(titleBorderDanhSach);
		DictionaryManagement myDictionaryManager= new DictionaryManagement();
		myDictionaryManager.insertFromFile();
		for (Word i:myDictionaryManager.getDataDictionary()) { 
            vec.add( i);
            }
		listWord.setListData(vec);
		
		pnList.add(lblList);
		
		JScrollPane scList=new JScrollPane(listWord,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnList.add(scList);
		
		pnDanhSachVaChiTiet.add(pnList);
		
		
		pnDanhSachVaChiTiet.add(pnList);
		JPanel pnChiTiet= new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		
		Border borderChiTiet=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderChiTiet= new TitledBorder(borderChiTiet, "Thông Tin Chi Tiết");
		titleBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titleBorderChiTiet.setTitleColor(Color.RED);
		pnChiTiet.setBorder(titleBorderChiTiet);
		
		pnDanhSachVaChiTiet.add(pnChiTiet);
		
		JPanel pnWord_taget= new JPanel();
		pnWord_taget.setLayout(new FlowLayout());
		JLabel lblWord_taget= new JLabel("Word_taget: ");
		txtWord_taget= new JTextField(20);
		pnWord_taget.add(lblWord_taget);
		pnWord_taget.add(txtWord_taget);
		pnChiTiet.add(pnWord_taget);
		
		JPanel pnWord_explain= new JPanel();
		pnWord_explain.setLayout(new FlowLayout());
		JLabel lblWord_explain= new JLabel("Word_explain: ");
		txtWord_explain= new JTextField(20);
		pnWord_taget.add(lblWord_explain);
		pnWord_taget.add(txtWord_explain);
		pnChiTiet.add(pnWord_explain);
		lblWord_taget.setPreferredSize(lblWord_explain.getPreferredSize());
		
		JPanel pnButton= new JPanel();
		
		Border borderButton=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderButton= new TitledBorder(borderButton, "Chức Năng");
		titleBorderButton.setTitleJustification(TitledBorder.CENTER);
		titleBorderButton.setTitleColor(Color.RED);
		pnButton.setBorder(titleBorderButton);
		
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnThem=new JButton("Add Word");
		btnXoa= new JButton("Delete Word");
		btnThoat= new JButton("Exit");
		btnThoat.setIcon(new ImageIcon("image/exit.png"));
		btnSearch= new JButton("Search");
		pnButton.add(btnSearch);
		pnButton.add(btnThem);
		pnButton.add(btnXoa);
		pnButton.add(btnThoat);
		pnMain.add( pnButton);
		
		
	}
	public void addEvents()
	{
		
		listWord.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(listWord.getSelectedIndex()==-1) return;
				wordSelected= (Word) listWord.getSelectedValue(); 
				txtWord_taget.setText(wordSelected.getWord_taget());
				txtWord_explain.setText(wordSelected.getWord_explain());
			}
		});
		btnThem.addActionListener(new ActionListener() {         
            
			@Override                                           
			public void actionPerformed(ActionEvent e) {        
				// TODO Auto-generated method stub     
				XuLyThem();  
				
			}                                                   
		});          
		btnXoa.addActionListener(new ActionListener() {  
            
			@Override                                    
			public void actionPerformed(ActionEvent e) { 
				// TODO Auto-generated method stub       
				XuLyXoa();                               
			}                                            
		});                                              
		
btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		
	}
	protected void XuLyXoa() {
		// TODO Auto-generated method stub
		if(wordSelected!=null)                                    
		{                                                       
			vec.remove(wordSelected);       
			wordSelected=null;                                    
			listWord.setListData(vec);
		}                                                       
		                                                                                                  
		                                                           
	}
	protected void XuLyThem() {      
		try {  
		
		 Word newWord = new Word(txtWord_taget.getText(),txtWord_explain.getText());
			                      
					
		 if(wordSelected!=null)                                    
			{   
				
				vec.add(wordSelected);
				listWord.setListData(vec);       
			}                                           
			                                                    
            
} catch (Exception ex) {                                  
// TODO: handle exception                             
JOptionPane.showMessageDialog(null, ex.toString());   
}                                                         
                         
		                                                        
		
	}
	public void showWindows()
	{
		this.setSize(700,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
