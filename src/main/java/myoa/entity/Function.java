package myoa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FUNCTION")
public class Function {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String code;
	private Boolean ismenuitem;
	private String menuLogo;
	private String menuEntry;
	private Integer parentId;
	public Boolean getIsmenuitem() {
		return ismenuitem;
	}
	public void setIsmenuitem(Boolean ismenuitem) {
		this.ismenuitem = ismenuitem;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getIsmenuItem() {
		return ismenuitem;
	}
	public void setIsmenuItem(Boolean ismenuItem) {
		this.ismenuitem = ismenuItem;
	}
	public String getMenuLogo() {
		return menuLogo;
	}
	public void setMenuLogo(String menuLogo) {
		this.menuLogo = menuLogo;
	}
	public String getMenuEntry() {
		return menuEntry;
	}
	public void setMenuEntry(String menuEntry) {
		this.menuEntry = menuEntry;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}
