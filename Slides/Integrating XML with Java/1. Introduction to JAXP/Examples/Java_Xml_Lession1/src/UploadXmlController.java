import java.io.ByteArrayInputStream;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (!item.isFormField()) {
						String fieldName = item.getFieldName();
						String fileName = item.getName();
						String contentType = item.getContentType();
						boolean isInMemory = item.isInMemory();
						long sizeInBytes = item.getSize();
						String content = item.getString();
						if (sizeInBytes > 0) {
							System.out.println(fieldName);
							System.out.println(fileName);
							System.out.println(contentType);
							System.out.println(isInMemory);
							System.out.println(sizeInBytes);
							HttpSession session = request.getSession();
							session.setAttribute("xml_name", fileName);
							session.setAttribute("xml_size", sizeInBytes);
							session.setAttribute("xml_doc", content);
						}
					} else {
						if (item.getFieldName().equals("txtNode")) {
							int nodeCount = 0;
							String nodeParse = item.getString();
							try {
								String content = request.getSession()
										.getAttribute("xml_doc").toString();
								byte[] bytes = content.getBytes();
								InputStream inputStream = new ByteArrayInputStream(
										bytes);
								DocumentBuilderFactory builderFactory = DocumentBuilderFactory
										.newInstance();
								DocumentBuilder builder = builderFactory
										.newDocumentBuilder();
								Document root = builder.parse(inputStream);
								NodeList nodeList = root
										.getElementsByTagName(nodeParse);
								for (int i = 0; i < nodeList.getLength(); i++) {
									++nodeCount;
								}
								request.setAttribute("nodeCount", nodeCount);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
