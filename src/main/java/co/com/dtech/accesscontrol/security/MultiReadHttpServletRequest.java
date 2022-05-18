package co.com.dtech.accesscontrol.security;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StreamUtils;

public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {

	public static final String DEFAULT_ENCODING = "UTF-8";
	private byte[] body;

	public MultiReadHttpServletRequest(HttpServletRequest httpServletRequest) throws IOException {

		super(httpServletRequest);
		// Read the request body and save it as a byte array
		InputStream is = super.getInputStream();

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		StreamUtils.copy(is, output);

		body = output.toByteArray();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return new ServletInputStreamImpl(new ByteArrayInputStream(body));
	}

	@Override
	public BufferedReader getReader() throws IOException {
		String enc = getCharacterEncoding();
		if (enc == null)
			enc = DEFAULT_ENCODING;
		return new BufferedReader(new InputStreamReader(getInputStream(), enc));
	}

	private static class ServletInputStreamImpl extends ServletInputStream {

		private InputStream is;

		public ServletInputStreamImpl(InputStream is) {
			this.is = is;
		}

		public int read() throws IOException {
			return is.read();
		}

		public boolean markSupported() {
			return false;
		}

		public synchronized void mark(int i) {
			throw new RuntimeException(new IOException("mark/reset not supported"));
		}

		public synchronized void reset() throws IOException {
			throw new IOException("mark/reset not supported");
		}

		@Override
		public boolean isFinished() {
			try {
				return is.available() == 0;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public boolean isReady() {
			return true;
		}

		@Override
		public void setReadListener(ReadListener listener) {
			throw new RuntimeException("Not implemented");
		}
	}
}
