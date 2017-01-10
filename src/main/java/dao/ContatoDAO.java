
package dao;

import model.Contato;
import util.GenericDAO;

public class ContatoDAO extends GenericDAO<Contato>{

    @Override
    public Class<Contato> getClassType() {
        return Contato.class;
    }
 
}
