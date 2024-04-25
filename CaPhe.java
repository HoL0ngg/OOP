public class CaPhe extends SanPham {
	private boolean isIced;

	public CaPhe() {
		super();
	}

	public CaPhe(String id, String ten) {
		super(id, ten);
	}

	public CaPhe(boolean isIced) {
		super();
		this.isIced = isIced;
	}

	public boolean isIced() {
		return isIced;
	}

	public void setIced(boolean isIced) {
		this.isIced = isIced;
	}

}
