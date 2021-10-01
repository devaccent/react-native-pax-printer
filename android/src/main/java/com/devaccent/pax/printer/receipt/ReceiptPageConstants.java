package com.devaccent.pax.printer.receipt;

import com.pax.gl.page.IPage.ILine.IUnit;
import com.pax.gl.page.IPage.EAlign;

import java.util.Map;
import java.util.HashMap;

public class ReceiptPageConstants {
	public final static Integer FONT_SIZE_XXS = 8;
	public final static Integer FONT_SIZE_XS = 12;
	public final static Integer FONT_SIZE_SM = 16;
	public final static Integer FONT_SIZE_MD = 24;
	public final static Integer FONT_SIZE_LG = 28;
	public final static Integer FONT_SIZE_XL = 32;

	public final static HashMap FONT_SIZES = new HashMap() {{
		put("XXS", FONT_SIZE_XXS);
		put("XS", FONT_SIZE_XS);
		put("SM", FONT_SIZE_SM);
		put("MD", FONT_SIZE_MD);
		put("XL", FONT_SIZE_XL);
	}};

	public final static EAlign LEFT_ALIGNMENT = EAlign.LEFT;
	public final static EAlign CENTER_ALIGNMENT = EAlign.CENTER;
	public final static EAlign RIGHT_ALIGNMENT = EAlign.RIGHT;

	public final static HashMap ALIGNMENTS = new HashMap() {{
		put("LEFT", LEFT_ALIGNMENT);
		put("CENTER", CENTER_ALIGNMENT);
		put("RIGHT", RIGHT_ALIGNMENT);
	}};

	public final static Integer TEXT_STYLE_BOLD = IUnit.TEXT_STYLE_BOLD;
	public final static Integer TEXT_STYLE_UNDERLINE = IUnit.TEXT_STYLE_UNDERLINE;
	public final static Integer TEXT_STYLE_NORMAL = IUnit.TEXT_STYLE_NORMAL;
	public final static Integer TEXT_STYLE_ITALIC = IUnit.TEXT_STYLE_ITALIC;

	public final static HashMap TEXT_STYLES = new HashMap() {{
		put("NORMAL", TEXT_STYLE_NORMAL);
		put("BOLD", TEXT_STYLE_BOLD);
		put("ITALIC", TEXT_STYLE_ITALIC);
		put("UNDERLINE", TEXT_STYLE_UNDERLINE);
	}};
}
