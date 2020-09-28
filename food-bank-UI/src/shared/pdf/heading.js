export default (doc, data, startY, fontSizes, lineSpacing) => {
  const invoiceNrTxt = data.label.orderTitle;
  let startX = 57;
  const pageWidth = doc.internal.pageSize.width;
  const endX = pageWidth - startX;

  doc.setFont("WorkSans", "normal");
  doc.setFontSize(fontSizes.SubTitleFontSize);

  // set fix value for Y to bring title in alignment with folding marks
  startY = 243;
  doc.text(invoiceNrTxt, startX, startY);

  doc.setFont("WorkSans", "bold");

  startX += doc.getStringUnitWidth(invoiceNrTxt) * fontSizes.SubTitleFontSize;
  doc.text(data.invoice.orderId, startX, startY);

  doc.setFont("WorkSans", "normal");
  const location = data.invoice.location ? data.invoice.location + ", " : "";
  doc.text(location + data.invoice.date, endX, startY, "right");

  startY += lineSpacing * 2;
  startX = 57;

  doc.setFontSize(fontSizes.TitleFontSize);
  doc.setDrawColor(157, 183, 128);
  doc.setLineWidth(0.5);
  startY += lineSpacing;
  doc.line(startX, startY, endX, startY);

  return startY;
};
