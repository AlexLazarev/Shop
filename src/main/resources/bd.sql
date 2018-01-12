
CREATE TRIGGER before_producer_delete BEFORE DELETE ON Producer
  FOR EACH ROW BEGIN
  DELETE FROM Supply WHERE producer_id = OLD.id;
END;


CREATE TRIGGER before_supply_delete BEFORE DELETE ON Supply
FOR EACH ROW BEGIN
UPDATE Product SET supply_id=Null WHERE supply_id = OLD.id;
END;

CREATE TRIGGER before_product_delete BEFORE DELETE ON Product
  FOR EACH ROW BEGIN
  DELETE FROM Rating WHERE product_id = OLD.id;
  DELETE FROM ProductInOrder WHERE product_id = OLD.id;
END;

CREATE TRIGGER before_order_delete BEFORE DELETE ON MyOrder
  FOR EACH ROW BEGIN
  DELETE FROM ProductInOrder WHERE order_id = OLD.id;
END;

