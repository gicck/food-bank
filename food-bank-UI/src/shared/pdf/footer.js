export default (doc, data, fontSize, lineSpacing) => {
  const pageHeight = doc.internal.pageSize.height;
  let startY = pageHeight - 120;

  let startX = 57;
  const pageWidth = doc.internal.pageSize.width;
  const endX = pageWidth - startX;

  doc.setDrawColor(157, 183, 128);
  doc.setLineWidth(0.5);
  doc.line(startX, startY, endX, startY);
  startY += lineSpacing;

  doc.setFontSize(fontSize);
  doc.setFont("WorkSans", "italic");

  doc.text(
    '"Gracias por el aporte de parte del Banco de Alimentos de Bolivia!!!!."',
    startX,
    startY
  );
};
