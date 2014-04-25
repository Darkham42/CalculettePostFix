package calculette;

import java.util.NoSuchElementException;

/**
 * La pile de calcul.
 */
public interface IPile
{

  /**
   * Empile une valeur.
   * Imprime la description sur la sortie standard si le mode de débogage est activé.
   * @param valeur la valeur à empiler
   */
  public void ajoute(Double valeur);

  /**
   * Dépile une valeur
   * @return la valeur dépilée
   * @throws NoSuchElementException si la pile est vide
   */
  public Double retire() throws NoSuchElementException;

  @Override
  public String toString();

  /**
   * Teste si la pile est vide
   * @return vrai ssi la pile est vide
   */
  public boolean estVide();

}