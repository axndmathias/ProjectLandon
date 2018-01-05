/*GenericDomain é uma classe java que serve como chave primaria para as demais tabelas*/
/*@MappedSuperclass é uma notaçao que indica que a classe nao corresponde a uma tabela
 * mas sera usada por outros para gerar tabelas
 */

package ch.hesperidian.landon.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class GenericDomain implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;
	
	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}

}
