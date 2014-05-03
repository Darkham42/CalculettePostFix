package calculettePostFix;

import java.util.HashMap;

import calculette.IExpression;
import calculette.IIdentifiants;
import calculette.IPile;

public class Identifiants implements IIdentifiants {

	private HashMap<String, IExpression> mTable = new HashMap<String, IExpression>();

	public int getNombre() {
		return mTable.size();
	}

	public void ajoute(String id) throws IllegalAccessError {
		mTable.put(id, new UneExpression(null));
	}

	public String set(String id, IExpression valeur) {
		mTable.put(id, valeur);
		return id;
	}

	public IExpression get(String id) {
		return mTable.get(id);
	}

	public boolean contient(String id) {
		return mTable.containsKey(id);
	}

	public double calcule(IPile pile, String id) {
		return mTable.get(id).calcule(pile, null);
	}

	public boolean estCalculable(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
