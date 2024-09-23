package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.User;

public class TableUser extends AbstractTableModel{
List<User> ls;
private String[] columnNames = {"ID","Name","Username","Password"};
public TableUser(List<User> ls) {
	this.ls = ls;
}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return ls.get(rowIndex).getId();
		case 1:
			return ls.get(rowIndex).getNama();
		case 2:
			return ls.get(rowIndex).getUsername();
		default:
		return null;
	}
	}
}