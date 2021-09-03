/**
 * 
 */
package ec.com.pruebagizlo.ms.usuario.utils.patterns;

public interface ICommand {

	Object execute(IParam parameter);

	void undo();

}
