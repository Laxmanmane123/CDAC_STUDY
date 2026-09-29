import { useState, useEffect } from 'react';

function App() {
  const [products, setProducts] = useState([]);
  const [editingId, setEditingId] = useState(null);
  const [formData, setFormData] = useState({
    name: '',
    price: '',
    stockQuantity: '',
    unit: 'PIECE',
    description: '',
    categoryId: '1'
  });

  const API_URL = 'http://localhost:8080/api/products';

  // 1. READ: Fetch all products
  const fetchProducts = async () => {
    try {
      const res = await fetch(API_URL);
      const data = await res.json();
      setProducts(data);
    } catch (err) {
      console.error('Fetch error:', err);
    }
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  // 2. CREATE or UPDATE: Handle Form Submit
  const handleSubmit = async (e) => {
    e.preventDefault();
    const payload = {
      name: formData.name,
      price: parseFloat(formData.price),
      stockQuantity: parseInt(formData.stockQuantity),
      unit: formData.unit,
      description: formData.description,
      category: { id: parseInt(formData.categoryId) }
    };

    try {
      if (editingId) {
        // UPDATE (PUT)
        await fetch(`${API_URL}/${editingId}`, {
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(payload)
        });
        setEditingId(null);
      } else {
        // CREATE (POST)
        await fetch(API_URL, {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(payload)
        });
      }

      setFormData({ name: '', price: '', stockQuantity: '', unit: 'PIECE', description: '', categoryId: '1' });
      fetchProducts();
    } catch (err) {
      console.error('Save error:', err);
    }
  };

  // Populate form for Editing
  const handleEdit = (product) => {
    setEditingId(product.id);
    setFormData({
      name: product.name,
      price: product.price,
      stockQuantity: product.stockQuantity,
      unit: product.unit || 'PIECE',
      description: product.description || '',
      categoryId: product.category ? product.category.id : '1'
    });
  };

  // Cancel Edit mode
  const handleCancelEdit = () => {
    setEditingId(null);
    setFormData({ name: '', price: '', stockQuantity: '', unit: 'PIECE', description: '', categoryId: '1' });
  };

  // 3. DELETE: Remove product
  const handleDelete = async (id) => {
    if (window.confirm('Are you sure you want to delete this product?')) {
      try {
        await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
        fetchProducts();
      } catch (err) {
        console.error('Delete error:', err);
      }
    }
  };

  return (
    <div className="container py-4">
      <h2 className="mb-4 text-center">Artisan Avenue - Product Management</h2>

      {/* Form (Add or Edit) */}
      <div className={`card mb-4 shadow-sm ${editingId ? 'border-warning' : ''}`}>
        <div className={`card-header text-white ${editingId ? 'bg-warning text-dark' : 'bg-primary'}`}>
          {editingId ? `Edit Product (ID: ${editingId})` : 'Add New Product'}
        </div>
        <div className="card-body">
          <form onSubmit={handleSubmit}>
            <div className="row g-3">
              <div className="col-md-4">
                <label className="form-label">Product Name</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="e.g. Handmade Diya"
                  required
                  value={formData.name}
                  onChange={(e) => setFormData({ ...formData, name: e.target.value })}
                />
              </div>
              <div className="col-md-2">
                <label className="form-label">Price (₹)</label>
                <input
                  type="number"
                  step="0.01"
                  className="form-control"
                  placeholder="250.00"
                  required
                  value={formData.price}
                  onChange={(e) => setFormData({ ...formData, price: e.target.value })}
                />
              </div>
              <div className="col-md-2">
                <label className="form-label">Stock Quantity</label>
                <input
                  type="number"
                  className="form-control"
                  placeholder="50"
                  required
                  value={formData.stockQuantity}
                  onChange={(e) => setFormData({ ...formData, stockQuantity: e.target.value })}
                />
              </div>
              <div className="col-md-2">
                <label className="form-label">Unit</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="PIECE / KG"
                  value={formData.unit}
                  onChange={(e) => setFormData({ ...formData, unit: e.target.value })}
                />
              </div>
              <div className="col-md-2">
                <label className="form-label">Category ID</label>
                <input
                  type="number"
                  className="form-control"
                  placeholder="1"
                  required
                  value={formData.categoryId}
                  onChange={(e) => setFormData({ ...formData, categoryId: e.target.value })}
                />
              </div>
              <div className="col-12">
                <label className="form-label">Description</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter brief product details..."
                  value={formData.description}
                  onChange={(e) => setFormData({ ...formData, description: e.target.value })}
                />
              </div>
            </div>
            <div className="mt-3">
              <button type="submit" className={`btn ${editingId ? 'btn-warning' : 'btn-success'}`}>
                {editingId ? 'Update Product' : 'Save Product'}
              </button>
              {editingId && (
                <button type="button" className="btn btn-secondary ms-2" onClick={handleCancelEdit}>
                  Cancel
                </button>
              )}
            </div>
          </form>
        </div>
      </div>

      {/* Product List Table */}
      <div className="card shadow-sm">
        <div className="card-header bg-dark text-white">Available Products</div>
        <div className="card-body p-0">
          <table className="table table-striped table-hover mb-0">
            <thead className="table-light">
              <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Unit</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {products.map((p) => (
                <tr key={p.id}>
                  <td>{p.id}</td>
                  <td><strong>{p.name}</strong><br/><small className="text-muted">{p.description}</small></td>
                  <td>{p.category ? p.category.name : 'N/A'}</td>
                  <td>₹{p.price}</td>
                  <td>{p.stockQuantity}</td>
                  <td>{p.unit}</td>
                  <td>
                    <button className="btn btn-primary btn-sm me-2" onClick={() => handleEdit(p)}>
                      Edit
                    </button>
                    <button className="btn btn-danger btn-sm" onClick={() => handleDelete(p.id)}>
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
              {products.length === 0 && (
                <tr>
                  <td colSpan="7" className="text-center py-3 text-muted">No products found. Add one above!</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default App;