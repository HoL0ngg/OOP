package SANPHAM;
public class CaPhe extends SanPham {
	private boolean coDa;

	public CaPhe() {
		super();
	}

	public CaPhe(String id, String ten) {
		super(id, ten);
	}

	public CaPhe(boolean coDa) {
		super();
		this.coDa = coDa;
	}

	public boolean isIced() {
		return coDa;
	}

	public void setIced(boolean isIced) {
		this.coDa = isIced;
	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
	}

}
