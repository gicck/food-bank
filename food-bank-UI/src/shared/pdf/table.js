import newPage from "./newPage";

export default (doc, printData, startY, fontSize, lineSpacing) => {
  let startX = 57;
  const pageWidth = doc.internal.pageSize.width;
  const endX = pageWidth - startX;

  const tablecol2X = 386;
  const tablecol3X = 460;

  doc.setFontSize(fontSize);
  doc.setFont("WorkSans", "normal");

  //-------Table Header---------------------
  startY += lineSpacing * 1.5;

  doc.text(printData.label.tableSinglePrice, tablecol3X, startY, "right");

  startY += lineSpacing;

  doc.line(startX, startY, endX, startY);

  startY += lineSpacing * 1.5;

  //-------Table Body---------------------

  const items = Object.values(printData.items);

  items.map(item => {
    doc.setFont("WorkSans", "bold");
    const splitTitle = doc.splitTextToSize(
      item.name,
      tablecol2X - startX - lineSpacing * 1.5
    );
    const heightTitle = splitTitle.length * doc.internal.getLineHeight();

    doc.setFont("WorkSans", "normal");
    const splitDescription = doc.splitTextToSize(
      item.itemDescription,
      tablecol2X - startX - lineSpacing * 1.5
    );
    const heightDescription =
      splitDescription.length * doc.internal.getLineHeight();

    // <><>><><>><>><><><><><>>><><<><><><><>
    // new page check before item output
    // @todo: display table header at start of a new page
    startY = newPage(doc, startY, heightDescription + heightTitle);

    doc.setFont("WorkSans", "bold");
    doc.text(splitTitle, startX, startY);
    // tweak Y to be below title. fits nicer with long descriptions. descriptions will be probably taking a row space while titles do not.
    startY += heightTitle;

    doc.setFont("WorkSans", "normal");
    doc.text(splitDescription, startX, startY);

    doc.text("", tablecol2X, startY, "right");

    doc.text(`${item.quantity}`, tablecol3X, startY, "right");

    doc.text(item.measureType, endX, startY, "right");

    startY += heightDescription + lineSpacing;
  });

  return startY;
};
