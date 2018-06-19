package Speichern;

import javax.sql.RowSet;
import Fachlogik.Autor;

public interface IAutorDAO {
	public void createAutor();
	public boolean deleteAutor();
	public Autor getAutor();
	public boolean updateAutor();
	public RowSet selectAutorRowSet();
	

}
