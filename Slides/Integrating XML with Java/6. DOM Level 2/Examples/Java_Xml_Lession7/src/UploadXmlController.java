
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class UploadXmlController
 */
public class UploadXmlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadXmlController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Set factory constraints
			factory.setSizeThreshold(10240);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Set overall request size constraint
			upload.setSizeMax(20480);

			// Parse the request
			try {
				List<?> items = upload.parseRequest(request);
				// Process the upload items
				Iterator<?> iter = items.iterator();
				HttpSession session = session = request.getSession();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (!item.isFormField()) {
						String fileName = item.getName();
						long sizeInBytes = item.getSize();
						String content = item.getString();
						if (sizeInBytes > 0) {
							session.setAttribute("xml_name", fileName);
							session.setAttribute("xml_size", sizeInBytes);
							session.setAttribute("xml_doc", content);
						}
					} else {
						if (item.getFieldName().equals("tatXml")) {
							String xml = item.getString().trim();
							try {
								byte[] bytes = xml.getBytes();
								InputStream inputStream = new ByteArrayInputStream(bytes);
								DocumentBuilderFactory builderFactory = DocumentBuilderFactory
										.newInstance();
								DocumentBuilder builder = builderFactory.newDocumentBuilder();
								Document doc = builder.parse(inputStream);

								// DOM document for writing.
								Source source = new DOMSource(doc);
								// Output file
								File file = new File(request.getRealPath("/") + "saved_xml.xml");
								StreamResult result = new StreamResult(file);

								// Perform transfomer.
								Transformer transformer = TransformerFactory.newInstance().newTransformer();
								transformer.transform(source, result);

								session.setAttribute("xml_name", "saved_xml.xml");
								session.setAttribute("xml_size", item.getSize());
								session.setAttribute("xml_doc", xml);

							} catch (Exception e) {
								request.setAttribute("error", e.getMessage());
								session.setAttribute("xml_name", null);
								session.setAttribute("xml_size", null);
								session.setAttribute("xml_doc", null);
							}
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
