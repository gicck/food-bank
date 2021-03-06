import { jsPDF } from "jspdf";
import addFontNormal from "./fonts/WorkSans-normal";
import addFontBold from "./fonts/WorkSans-bold";
import fetchSvg from "./pdf/fetchSvg";
import addressSender from "./pdf/addressSender";
import addressCustomer from "./pdf/addressCustomer";
import heading from "./pdf/heading";
import table from "./pdf/table";
import text from "./pdf/text";
import footer from "./pdf/footer";
import logo from "./pdf/logo";

const printPDF = function(order) {
  console.log(order);

  const basePrintData = {
    addressSender: {
      entityName: order.entityName, //entityName
      entityEmployeeName: order.entityEmployeeName, //entityEmployeeName
      entityEmployeePhone: `+591 ${order.entityEmployeePhone}` //entityEmployeePhone
    },
    address: {
      company: "Banco de Alimentos de Bolivia",
      employeeName: order.employeeName, //employeeName
      city: "Cochabamba"
    },
    label: {
      orderTitle: "Orden No.",
      tableSinglePrice: "Cantidad"
    }
  };
  const shortPrintData = {
    invoice: {
      orderId: `OB-${order.id}`, // orderId
      date: "17.09.2020",
      text: ""
    },
    items: order.items
  };

  const printData = Object.assign(basePrintData, shortPrintData);

  addFontNormal();
  addFontBold();
  const doc = new jsPDF("p", "pt");
  doc.setFont("WorkSans", "bold");

  // <><>><><>><>><><><><><>>><><<><><><><>
  // SETTINGS
  // <><>><><>><>><><><><><>>><><<><><><><>

  const fontSizes = {
    TitleFontSize: 14,
    SubTitleFontSize: 12,
    NormalFontSize: 10,
    SmallFontSize: 9
  };
  const lineSpacing = 12;

  let startY = 130; // bit more then 45mm

  const pageHeight = doc.internal.pageSize.height;
  const pageWidth = doc.internal.pageSize.width;
  const pageCenterX = pageWidth / 2;

  // <><>><><>><>><><><><><>>><><<><><><><>
  // COMPONENTS
  // <><>><><>><>><><><><><>>><><<><><><><>

  // <><>><><>><>><><><><><>>><><<><><><><>
  // Background init
  // need to print the background before other elements get printed on
  fetchSvg(doc, "img/background.svg").then(() => {
    // if (svg) {
    //     doc.setPage(1);
    //     svg2pdf(svg, doc, {
    //         xOffset: -70,
    //         yOffset: 250
    //     });
    //     localStorage.setItem('bgSvg', new XMLSerializer().serializeToString(svg));
    // }

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Sender's address
    startY = addressSender(
      doc,
      printData.addressSender,
      startY,
      fontSizes.SubTitleFontSize,
      lineSpacing
    );

    const addressSvgLoaded = fetchSvg(doc, "img/address-bar.svg").then(() => {
      // if (svg) {
      //     doc.setPage(1);
      //     svg2pdf(svg, doc, {
      //         xOffset: 225,
      //         yOffset: 136,
      //         scale: 0.45 // scaling for finer details
      //     });
      // }
    });
    // <><>><><>><>><><><><><>>><><<><><><><>
    // Customer address

    startY += 10;
    startY = addressCustomer(
      doc,
      printData.address,
      startY,
      fontSizes.NormalFontSize,
      lineSpacing
    );

    // <><>><><>><>><><><><><>>><><<><><><><>
    // INVOICE DATA
    // <><>><><>><>><><><><><>>><><<><><><><>

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Invoicenumber, -date and subject

    startY = heading(doc, printData, startY, fontSizes, lineSpacing);

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Table with items

    startY = table(
      doc,
      printData,
      startY,
      fontSizes.NormalFontSize,
      lineSpacing
    );

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Totals
    let startX = 57;
    const endX = pageWidth - startX;

    doc.setDrawColor(157, 183, 128);
    doc.setLineWidth(0.5);
    doc.line(startX, startY, endX, startY);

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Text

    startY = text(
      doc,
      printData.invoice.text,
      startY,
      fontSizes.NormalFontSize,
      lineSpacing
    );

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Footer

    footer(doc, printData, fontSizes.SmallFontSize, lineSpacing);

    // <><>><><>><>><><><><><>>><><<><><><><>
    // REPEATED PAGE COMPONENTS
    // <><>><><>><>><><><><><>>><><<><><><><>

    const pageNr = doc.internal.getNumberOfPages();

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Fold Marks

    const foldX = 12;
    const foldMarksY = [288, 411, 585];
    let n = 0;

    while (n < pageNr) {
      n++;

      doc.setPage(n);

      doc.setDrawColor(157, 183, 128);
      doc.setLineWidth(0.5);

      foldMarksY.map(valueY => {
        doc.line(foldX, valueY, foldX + 23, valueY);
      });
    }

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Logo

    const logoLoaded = logo(doc, printData, pageNr);

    // <><>><><>><>><><><><><>>><><<><><><><>
    // Page Numbers

    if (pageNr > 1) {
      n = 0;
      doc.setFontSize(fontSizes.SmallFontSize);

      while (n < pageNr) {
        n++;

        doc.setPage(n);

        doc.text(n + " / " + pageNr, pageCenterX, pageHeight - 20, "center");
      }
    }

    // <><>><><>><>><><><><><>>><><<><><><><>
    // PRINT
    // <><>><><>><>><><><><><>>><><<><><><><>

    Promise.all([addressSvgLoaded, logoLoaded]).then(() => {
      doc.save("order.pdf");
    });
  });
};

export const exportService = {
  printPDF
};
