import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

/**http://stackoverflow.com/questions/1065691/how-to-set-the-background-color-of-a-jbutton-on-the-mac-os
*http://stackoverflow.com/questions/21077322/create-a-chess-board-with-jpanel
*/
public class ChessGUI extends ChessBoard {
	/**
	 * initializing columns 
	 * initializing buttons for each square
	 * initializing chessboard
	 */

	private final JPanel uInt = new JPanel();
	private JButton[][] boardButtons = new JButton[8][8];
	private JPanel cBoard;
	private static String cols = "ABCDEFGH";

	ChessGUI() {
		ChessBoard chessB = new ChessBoard(true); 
		setGUI(chessB);
	}

	/**
	 * 
	 * @param chessB is the chessboard
	 * @returns the UI of the board including the borders, grid, etc.
	 */
	public final void setGUI(ChessBoard chessB) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		// set up the main GUI
		JToolBar tools = new JToolBar();
		uInt.add(tools, BorderLayout.PAGE_START);
		tools.add(new JButton("New Game")); 

		cBoard = new JPanel(new GridLayout(0, 9));
		cBoard.setBorder(new LineBorder(Color.BLUE));
		uInt.add(cBoard);

		// creating the board squares
		for (int xx = 0; xx < boardButtons.length; xx++) {
			for (int yy = 0; yy < boardButtons[xx].length; yy++) {
				JButton button = new JButton();
				button.setMargin(new Insets(0,0,0,0));
				Icon image = new ImageIcon(new BufferedImage(55, 55, BufferedImage.TYPE_INT_ARGB));
				chessPiece piece = chessB.board[xx][yy];
				if(piece != null){
					image = getImage(piece);
				}
				button.setIcon(image);
				if ((yy % 2 == 1 && xx % 2 == 1)
						|| (yy % 2 == 0 && xx % 2 == 0)) {
					button.setBackground(Color.WHITE);
				} else {
					button.setBackground(Color.DARK_GRAY);
				}
				boardButtons[xx][yy] = button;
			}
		}

		//fill the chess board
		cBoard.add(new JLabel(""));
		for (int xx = 0; xx < 8; xx++) {
			cBoard.add(new JLabel(cols.substring(xx, xx + 1), SwingConstants.CENTER));
		}
		
		for (int xx = 0; xx < 8; xx++) {
			for (int yy = 0; yy < 8; yy++) {
				switch (yy) {
				case 0:
					cBoard.add(new JLabel("" + (xx + 1), SwingConstants.CENTER));
				default:
					cBoard.add(boardButtons[yy][xx]);
				}
			}
		}
	}

	public final JComponent getChessBoard() {
		return cBoard;
	}

	public final JComponent getGui() {
		return uInt;
	}
	
	/**
	 * 
	 * @param cp chesspiece whose image we want to get
	 * @returns the different black, white and custom chess pieces from the appropriate folder
	 */
	public Icon getImage(chessPiece cp){
		if (cp == null){
			return new ImageIcon (new BufferedImage(55,55,BufferedImage.TYPE_INT_ARGB));
		}
		
		String folder = "/images/";
		
		String ptype = cp.getType();
		switch(ptype){
		case "bishop":
			folder += "bishop";
			break;
		case "king":
			folder += "king";
			break;
		case "knight":
			folder += "knight";
			break;
		case "miniqueen":
			folder += "miniqueen";
			break;
		case "pawn":
			folder += "pawn";
			break;
		case "queen":
			folder += "queen";
			break;
		case "rook":
			folder += "rook";
			break;
		case "superpawn":
			folder += "superpawn";
			break;
		
		}
		
		if (cp.getColor().equals("white")){
			folder += ".png";
		}
		else{
			folder += "b.png";
		}
		
		Icon image = null;
		try{
			Image img = ImageIO.read(getClass().getResource(folder));
			image = new ImageIcon(img);
		}   catch (IOException ex){}
		
		return image;
}
	
	
	
	
	
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			
			public void run() {
				
				ChessGUI tile = new ChessGUI();

				JFrame title = new JFrame("Chess");
				title.add(tile.getGui());
				title.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				title.setLocationByPlatform(true);

				// minimum size of frame
				title.pack();
				title.setMinimumSize(title.getSize());
				title.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}